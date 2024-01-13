package com.pourya.streamchallenge.modules.kafka.service

import com.pourya.streamchallenge.modules.ad_event.presentation.ClickEventDto
import com.pourya.streamchallenge.modules.ad_event.presentation.ImpressionEventDto
import com.pourya.streamchallenge.modules.kafka.enumeration.AdEventEnum
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import com.pourya.streamchallenge.modules.ad_event.business.AdService

@Service
class KafkaConsumer(val adService: AdService) {

    @KafkaListener(topics = [AdEventEnum.IMPRESSION], groupId = "com.pourya")
    fun listenImpressionEvent(message: ImpressionEventDto) {
        adService.createImpression(message)
    }

    @KafkaListener(topics = [AdEventEnum.CLICK], groupId = "com.pourya")
    fun listenClickEvent(message: ClickEventDto) {
        adService.addClick(message)
    }



}
