package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.EventLogDb
import pl.inpost.domain.data.EventLog
import javax.inject.Inject

class EventLogDbMapper @Inject constructor() {
    fun toDomain(eventLogDb: EventLogDb) = with(eventLogDb) {
        EventLog(
            name = name,
            date = date,
        )
    }
}
