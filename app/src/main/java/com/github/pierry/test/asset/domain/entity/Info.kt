package com.github.pierry.test.asset.domain.entity

import com.github.pierry.test.core.domain.InvalidData

data class Info(
        val name: String = InvalidData.INVALID_STRING,
        val data: String = InvalidData.INVALID_STRING
)