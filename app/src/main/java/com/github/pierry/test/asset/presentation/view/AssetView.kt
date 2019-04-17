package com.github.pierry.test.asset.presentation.view

import com.github.pierry.test.asset.presentation.model.HeaderInfos
import com.github.pierry.test.asset.presentation.model.Info
import com.github.pierry.test.asset.presentation.model.MoreInfos
import com.github.pierry.test.asset.presentation.model.RiskInfo
import com.github.pierry.test.core.presentation.BaseView

interface AssetView : BaseView {

  fun setHeaderInfos(headerInfo: HeaderInfos)
  fun setRiskInfos(riskInfo: RiskInfo)
  fun setMoreInfos(moreInfos: MoreInfos)
  fun setListInfos(infos: MutableList<Info>)
  fun setDownInfos(infos: MutableList<Info>)

}