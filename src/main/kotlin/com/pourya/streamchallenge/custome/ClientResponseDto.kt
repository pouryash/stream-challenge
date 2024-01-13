package com.pourya.streamchallenge.custome

import java.io.Serializable
import java.time.Instant

data class ClientResponseDto<T>(

    val data: T,

    val message: String,

    val currentTime: Long = Instant.now().toEpochMilli(),

    val returnCode: Int = 0
) : Serializable