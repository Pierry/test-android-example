package com.github.pierry.test.form.presentation.presenter

import com.github.pierry.test.form.domain.CellRepository
import com.github.pierry.test.form.domain.cell.Cell
import com.github.pierry.test.form.presentation.domain.cell.FormViewBuilder
import com.github.pierry.test.form.presentation.view.FormView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class FormPresenterImpl(
        private val view: FormView,
        private val repository: CellRepository
) : FormPresenter {

  private val compositeDisposable = CompositeDisposable()

  override fun onSendEventClicked() {
    if (view.isFormError()) {
      view.showFormErrors()
    } else {
      view.showSuccessView()
    }
  }

  override fun onSendNewMessageClicked() {
    view.clearForm()
    view.hideSuccessView()
  }

  override fun onStart() {
    view.hideSuccessView()
    view.showLoading()
    compositeDisposable.add(
            repository.getCells()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ listCell ->
                      proccessResponse(listCell)
                      view.hideSuccessView()
                      view.hideError()
                      view.hideLoading()
                    }, { error ->
                      Timber.e(error)
                      view.hideLoading()
                      view.showError()
                    })
    )
  }

  private fun proccessResponse(listCell: MutableList<Cell>) {
    val formViewBuilder = FormViewBuilder(view.getFormLayout())
    formViewBuilder.proccessCellsFormView(listCell)
    view.setFormLayoutListeners()
  }

  override fun onPause() {
    compositeDisposable.clear()
  }

}