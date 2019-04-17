package com.github.pierry.test.asset.presentation.model.mapper

import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.presentation.model.HeaderInfos

object HeaderMapper {

    fun map(asset: Asset) = HeaderInfos(
            asset.title,
            asset.assetName,
            asset.whatIs,
            asset.definition
    )

}