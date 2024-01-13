package com.pourya.streamchallenge.modules.ad_event.business


import com.pourya.streamchallenge.modules.ad_event.mapper.AdMapper
import com.pourya.streamchallenge.modules.ad_event.persistence.AdEvent
import com.pourya.streamchallenge.modules.ad_event.persistence.AdEventRepository
import com.pourya.streamchallenge.modules.ad_event.presentation.ClickEventDto
import com.pourya.streamchallenge.modules.ad_event.presentation.ImpressionEventDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(rollbackFor = [Exception::class])
class AdService(val adEventRepository: AdEventRepository, val adMapper: AdMapper) {

    fun createImpression(dto: ImpressionEventDto) : ImpressionEventDto {
        if (!adEventRepository.findAdEventByRequestId(dto.requestId).isEmpty)
            throw RuntimeException("duplicated request id")

        val adEvent = adMapper.toEntity(dto)

        adEventRepository.save(adEvent)
        return dto
    }

    fun addClick(dto: ClickEventDto) : ClickEventDto {
       val adEvent: Optional<AdEvent> = adEventRepository.findAdEventByRequestId(dto.requestId)

        if (!adEvent.isPresent)
            throw RuntimeException("request id not exist")

        adEvent.get().clickTime = dto.clickTime

        adEventRepository.save(adEvent.get())
        return dto
    }


}