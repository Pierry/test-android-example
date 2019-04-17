package com.github.pierry.test.asset.domain.entity

import com.github.pierry.test.core.domain.InvalidData

data class TimeInfo(
        val fund: Double = InvalidData.INVALID_DOUBLE,
        val cdi: Double = InvalidData.INVALID_DOUBLE
)