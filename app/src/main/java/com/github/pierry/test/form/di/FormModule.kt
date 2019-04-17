package com.github.pierry.test.form.di

import com.github.pierry.test.core.data.FloatingMountainApi
import com.github.pierry.test.form.data.CellRepositoryImpl
import com.github.pierry.test.form.domain.CellRepository
import com.github.pierry.test.form.presentation.presenter.FormPresenter
import com.github.pierry.test.form.presentation.presenter.FormPresenterImpl
import com.github.pierry.test.form.presentation.view.FormView
import dagger.Module
import dagger.Provides

@FormScope
@Module
class FormModule {

  @Provides
  fun providesCellsRepository(
          floatingMountainApi: FloatingMountainApi): CellRepository = CellRepositoryImpl(floatingMountainApi)

  @Provides
  fun providesFormPresenter(formView: FormView, cellRepository: CellRepository): FormPresenter =
          FormPresenterImpl(formView, cellRepository)

}