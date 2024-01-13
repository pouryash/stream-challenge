package com.pourya.streamchallenge.modules.ad_event.persistence

import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdEventRepository : CassandraRepository<AdEvent, UUID> {

    fun findAdEventByRequestId(requestId: String):Optional<AdEvent>

}