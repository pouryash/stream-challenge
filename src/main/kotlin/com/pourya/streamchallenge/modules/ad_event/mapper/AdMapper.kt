package com.pourya.streamchallenge.modules.ad_event.mapper

import com.pourya.streamchallenge.modules.ad_event.persistence.AdEvent
import com.pourya.streamchallenge.modules.ad_event.presentation.ImpressionEventDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface AdMapper {
    fun toEntity(dto: ImpressionEventDto): AdEvent
}