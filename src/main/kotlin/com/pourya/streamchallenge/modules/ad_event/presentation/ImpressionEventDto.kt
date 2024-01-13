package com.pourya.streamchallenge.modules.ad_event.presentation

data class ImpressionEventDto(
    val requestId: String,
    val adId: String,
    val adTitle: String,
    val advertiserCost: Double,
    val appId: String,
    val appTitle: String,
    val impressionTime: Long)