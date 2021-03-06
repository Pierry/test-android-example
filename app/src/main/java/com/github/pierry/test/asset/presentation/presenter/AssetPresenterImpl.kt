package com.github.pierry.test.asset.presentation.presenter

import com.github.pierry.test.asset.domain.AssetRepository
import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.presentation.model.mapper.*
import com.github.pierry.test.asset.presentation.view.AssetView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class AssetPresenterImpl(
        val view: AssetView,
        val repository: AssetRepository
) : AssetPresenter {

  private val compositeDisposable = CompositeDisposable()

  override fun onStart() {
    view.hideError()
    view.showLoading()
    compositeDisposable.add(
            repository.getAsset()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                      sendResponseToView(response)
                      view.hideLoading()
                    }, { error ->
                      Timber.e(error)
                      view.hideLoading()
                      view.showError()
                    })
    )
  }

  private fun sendResponseToView(asset: Asset) {
    view.setHeaderInfos(HeaderMapper.map(asset))
    view.setRiskInfos(RiskMapper.map(asset))
    view.setMoreInfos(MoreInfosMapper.map(asset))
    view.setListInfos(SimpleInfosMapper.map(asset))
    view.setDownInfos(DownInfosMapper.map(asset))
  }

  override fun onPause() {
    compositeDisposable.clear()
  }
}