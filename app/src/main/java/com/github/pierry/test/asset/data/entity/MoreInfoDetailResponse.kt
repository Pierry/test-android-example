package com.github.pierry.test.asset.data.entity

import com.google.gson.annotations.SerializedName

data class MoreInfoDetailResponse(
        @SerializedName("fund") val fund: Double?,
        @SerializedName("CDI") val CDI: Double?
)