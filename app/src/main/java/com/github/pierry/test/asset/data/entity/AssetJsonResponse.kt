package com.github.pierry.test.asset.data.entity

import com.google.gson.annotations.SerializedName

data class AssetJsonResponse(
        @SerializedName("screen") val screen: ScreenResponse?
)