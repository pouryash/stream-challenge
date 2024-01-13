package com.pourya.streamchallenge.schedule

import com.pourya.streamchallenge.modules.ad_event.presentation.ClickEventDto
import com.pourya.streamchallenge.modules.ad_event.presentation.ImpressionEventDto
import com.pourya.streamchallenge.modules.kafka.enumeration.AdEventEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import com.pourya.streamchallenge.modules.kafka.service.KafkaProducer
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.random.Random
import kotlin.random.nextLong


@Component
class ScheduleService @Autowired constructor(private val kafkaProducer: KafkaProducer) {

    var requestQueue: Queue<String> = ConcurrentLinkedQueue()

    @Scheduled(cron = "0/1 * * * * *")
    fun scheduleEachSecond() {

        val requestId = UUID.randomUUID().toString()
        requestQueue.add(requestId)

        kafkaProducer.sendMessage(
            AdEventEnum.IMPRESSION, ImpressionEventDto(
                requestId = requestId,
                adId = "2",
                adTitle = "use queue test",
                advertiserCost = 0.1,
                appId = "11",
                appTitle = "app test",
                impressionTime = Random.nextLong(LongRange(1, 20))
            )
        )

    }

    @Scheduled(cron = "0/5 * * * * *")
    fun scheduleEachFiveSecond() {
        requestQueue.forEach {
            it?.let {
                kafkaProducer.sendMessage(AdEventEnum.CLICK, ClickEventDto(it, Random.nextLong(LongRange(60, 110))))
                requestQueue.remove(it)
            }
        }
    }

}
