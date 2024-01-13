package com.pourya.streamchallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableCassandraRepositories(basePackages = arrayOf("com.pourya"))
@SpringBootApplication(scanBasePackages = ["com.pourya"])
@EnableScheduling
class StreamChallengeApplication

fun main(args: Array<String>) {
    runApplication<StreamChallengeApplication>(*args)
}
