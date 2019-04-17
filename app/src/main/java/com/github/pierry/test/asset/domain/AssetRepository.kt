package com.github.pierry.test.asset.domain

import com.github.pierry.test.asset.domain.entity.Asset
import io.reactivex.Flowable

interface AssetRepository {

  fun getAsset(): Flowable<Asset>

}