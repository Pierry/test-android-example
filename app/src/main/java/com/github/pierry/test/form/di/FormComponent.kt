package com.github.pierry.test.form.di

import com.github.pierry.test.form.presentation.view.FormFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FormScope
@Subcomponent(modules = [
  FormModule::class,
  FormModuleView::class
])
interface FormComponent : AndroidInjector<FormFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<FormFragment>()

}