package com.github.pierry.test.form.di

import com.github.pierry.test.form.presentation.view.FormFragment
import com.github.pierry.test.form.presentation.view.FormView
import dagger.Binds
import dagger.Module

@FormScope
@Module
abstract class FormModuleView {

  @Binds
  abstract fun bindFormView(fragment: FormFragment): FormView

}