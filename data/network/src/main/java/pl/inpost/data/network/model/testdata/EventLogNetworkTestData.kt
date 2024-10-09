package pl.inpost.data.network.model.testdata

import pl.inpost.data.network.model.EventLogNetwork
import java.time.ZonedDateTime

fun eventLogNetworkTestData() = listOf(
    EventLogNetwork(
        name = "READY_TO_PICKUP",
        date = ZonedDateTime.parse("2018-08-01T04:56:07Z"),
    ),
    EventLogNetwork(
        name = "SENT_FROM_SOURCE_BRANCH",
        date = ZonedDateTime.parse("2018-08-18T04:56:07Z"),
    ),
    EventLogNetwork(
        name = "CONFIRMED",
        date = ZonedDateTime.parse("2018-08-14T04:56:07Z"),
    ),
)
