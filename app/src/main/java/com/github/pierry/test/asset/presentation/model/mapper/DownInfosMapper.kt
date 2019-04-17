package com.github.pierry.test.asset.presentation.model.mapper

import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.presentation.model.Info

object DownInfosMapper {

  fun map(asset: Asset): MutableList<Info> {
    val listInfos = mutableListOf<Info>()
    asset.downInfo.mapTo(listInfos, { info -> Info(info.name, info.data) })
    return listInfos
  }

}