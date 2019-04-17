package com.github.pierry.test.asset.presentation.model.mapper

import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.presentation.model.RiskInfo

object RiskMapper {

  fun map(asset: Asset) = RiskInfo(
          asset.riskTitle,
          asset.risk
  )

}