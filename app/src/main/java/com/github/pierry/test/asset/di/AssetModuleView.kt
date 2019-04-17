package com.github.pierry.test.asset.di

import com.github.pierry.test.asset.presentation.view.AssetFragment
import com.github.pierry.test.asset.presentation.view.AssetView
import dagger.Binds
import dagger.Module

@Module
abstract class AssetModuleView {

  @Binds
  abstract fun bindAssetView(fragment: AssetFragment): AssetView

}