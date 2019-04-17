package com.github.pierry.test.asset.di

import com.github.pierry.test.asset.data.AssetRepositoryImpl
import com.google.gson.Gson
import com.github.pierry.test.asset.domain.AssetRepository
import com.github.pierry.test.asset.presentation.presenter.AssetPresenter
import com.github.pierry.test.asset.presentation.presenter.AssetPresenterImpl
import com.github.pierry.test.asset.presentation.view.AssetView
import com.github.pierry.test.core.data.FloatingMountainApi
import dagger.Module
import dagger.Provides

@Module
class AssetModule {

  @Provides
  fun providesAssetPresenter(
          assetView: AssetView,
          repository: AssetRepository
  ): AssetPresenter = AssetPresenterImpl(assetView, repository)

  @Provides
  fun providesAssetRepository(
          floatingMountainApi: FloatingMountainApi,
          gson: Gson
  ): AssetRepository = AssetRepositoryImpl(floatingMountainApi, gson)

}