package com.github.pierry.test.asset.presentation.model.mapper

import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.presentation.model.Info
import com.github.pierry.test.asset.presentation.model.MoreInfos

object MoreInfosMapper {

  fun map(asset: Asset) = MoreInfos(
          asset.infoTitle,
          Info(asset.monthInfo.fund.toString(), asset.monthInfo.cdi.toString()),
          Info(asset.yearInfo.fund.toString(), asset.yearInfo.cdi.toString()),
          Info(asset.twelveInfo.fund.toString(), asset.twelveInfo.cdi.toString())
  )

}