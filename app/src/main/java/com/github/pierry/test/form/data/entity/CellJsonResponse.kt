package com.github.pierry.test.form.data.entity

import com.google.gson.annotations.SerializedName

data class CellJsonResponse(
        @SerializedName("cells") val cells: MutableList<CellResponse>
)