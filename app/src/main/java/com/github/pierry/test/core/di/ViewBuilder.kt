package com.github.pierry.test.core.di

import android.support.v4.app.Fragment
import com.github.pierry.test.asset.di.AssetComponent
import com.github.pierry.test.asset.presentation.view.AssetFragment
import com.github.pierry.test.form.di.FormComponent
import com.github.pierry.test.form.presentation.view.FormFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewBuilder {

  @Binds
  @IntoMap
  @FragmentKey(FormFragment::class)
  abstract fun bindFormFragment(builder: FormComponent.Builder): AndroidInjector.Factory<out Fragment>

  @Binds
  @IntoMap
  @FragmentKey(AssetFragment::class)
  abstract fun bindAssetFragment(builder: AssetComponent.Builder): AndroidInjector.Factory<out Fragment>

}