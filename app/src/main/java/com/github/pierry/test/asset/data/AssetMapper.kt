package com.github.pierry.test.asset.data

import com.github.pierry.test.asset.data.entity.AssetJsonResponse
import com.github.pierry.test.asset.data.entity.InfoDetailResponse
import com.github.pierry.test.asset.data.entity.MoreInfoDetailResponse
import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.asset.domain.entity.Info
import com.github.pierry.test.asset.domain.entity.TimeInfo
import com.github.pierry.test.core.domain.InvalidData

object AssetMapper {

  fun map(assetJsonResponse: AssetJsonResponse): Asset {
    return Asset(
            assetJsonResponse.screen?.title ?: InvalidData.INVALID_STRING,
            assetJsonResponse.screen?.assetName ?: InvalidData.INVALID_STRING,
            assetJsonResponse.screen?.whatIs ?: InvalidData.INVALID_STRING,
            assetJsonResponse.screen?.definition ?: InvalidData.INVALID_STRING,
            assetJsonResponse.screen?.riskTitle ?: InvalidData.INVALID_STRING,
            assetJsonResponse.screen?.risk ?: InvalidData.INVALID_INT,
            assetJsonResponse.screen?.infoTitle ?: InvalidData.INVALID_STRING,
            map(assetJsonResponse.screen?.moreInfo?.month),
            map(assetJsonResponse.screen?.moreInfo?.year),
            map(assetJsonResponse.screen?.moreInfo?.twelveMonths),
            map(assetJsonResponse.screen?.info),
            map(assetJsonResponse.screen?.downInfo)
    )
  }

  private fun map(moreInfoDetailResponse: MoreInfoDetailResponse?) =
          TimeInfo(moreInfoDetailResponse?.fund ?: InvalidData.INVALID_DOUBLE,
                  moreInfoDetailResponse?.CDI ?: InvalidData.INVALID_DOUBLE)

  private fun map(infoDetailsList: MutableList<InfoDetailResponse>?): MutableList<Info> {
    val infoList = mutableListOf<Info>()
    infoDetailsList?.mapTo(infoList, { infoDetail -> map(infoDetail) })
    return infoList
  }

  private fun map(infoDetailResponse: InfoDetailResponse?) =
          Info(infoDetailResponse?.name ?: InvalidData.INVALID_STRING,
                  infoDetailResponse?.data ?: InvalidData.INVALID_STRING)

}