package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.EventLogNetwork
import pl.inpost.domain.data.EventLog
import javax.inject.Inject

class EventLogNetworkMapper @Inject constructor() {
    fun toDomain(eventLogNetwork: EventLogNetwork) = with(eventLogNetwork) {
        EventLog(
            name = name,
            date = date,
        )
    }
}
