package com.pourya.streamchallenge.modules.ad_event.presentation

import com.pourya.streamchallenge.custome.ClientResponseDto
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.pourya.streamchallenge.modules.ad_event.business.AdService

@RestController
@RequestMapping("/api/v1.0/ad")
class AdEventController(val adService: AdService) {

    private val USER_MESSAGE_OPERATION_SUCCESS = "OPERATION SUCCESS"


    @PostMapping("/impression")
    fun createPaymentId(@RequestBody @Validated dto: ImpressionEventDto): ClientResponseDto<Unit> {
        adService.createImpression(dto = dto)
        return ClientResponseDto(Unit, USER_MESSAGE_OPERATION_SUCCESS)
    }

}