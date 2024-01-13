package com.pourya.streamchallenge.modules.kafka.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, Any>) {

    fun sendMessage(topic: String, message: Any) {
        kafkaTemplate.send(topic, message)
    }
}
