package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.EventLogDb
import pl.inpost.domain.data.EventLog
import javax.inject.Inject

class EventLogDbMapper @Inject constructor() {
    fun toDomain(eventLogDb: EventLogDb) = with(eventLogDb) {
        EventLog(
            name = name,
            date = date,
        )
    }

    fun toEntity(eventLog: EventLog, shipmentNumber: String) = with(eventLog) {
        EventLogDb(
            name = name,
            date = date,
            shipmentNumber = shipmentNumber,
        )
    }

    fun toEntity(eventLog: List<EventLog>, shipmentNumber: String) = eventLog.map {
        toEntity(it, shipmentNumber)
    }
}
