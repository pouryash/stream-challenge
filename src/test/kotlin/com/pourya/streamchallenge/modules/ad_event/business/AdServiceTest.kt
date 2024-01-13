package com.pourya.streamchallenge.modules.ad_event.business

import com.pourya.streamchallenge.modules.ad_event.presentation.ClickEventDto
import com.pourya.streamchallenge.modules.ad_event.presentation.ImpressionEventDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import java.util.*
import kotlin.random.Random
import kotlin.random.nextLong


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdServiceTest {

    @Autowired
    private val adService: AdService? = null
    val requestId = UUID.randomUUID().toString()

    @Test
    @Order(1)
    @DirtiesContext
    fun createImpression() {

        val result = adService?.createImpression(
            ImpressionEventDto(
            requestId = requestId,
            adId = "2",
            adTitle = "use queue test",
            advertiserCost = 0.1,
            appId = "11",
            appTitle = "app test",
            impressionTime = Random.nextLong(LongRange(1, 20))
        )
        )

        assertThat(result).isNotNull

        assertThrows(
            Exception::class.java
        ) {
            adService?.createImpression(
                ImpressionEventDto(
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

    }

    @Test
    @Order(2)
    @DirtiesContext
    fun addClick() {
        val result = adService?.addClick(
            ClickEventDto(
                requestId = requestId,
                clickTime = Random.nextLong(LongRange(10, 80))
            )
        )
        assertThat(result).isNotNull

        assertThrows(
            Exception::class.java
        ) {
            adService?.addClick(
                ClickEventDto(
                    requestId = "fake request",
                    clickTime = Random.nextLong(LongRange(10, 80))
                )
            )
        }
    }
}