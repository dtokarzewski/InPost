package pl.inpost.data.database.model.testdata

import pl.inpost.data.network.model.EventLogDb
import java.time.ZonedDateTime

fun eventLogDbTestData() = listOf(
    EventLogDb(
        name = "READY_TO_PICKUP",
        date = ZonedDateTime.parse("2018-08-01T04:56:07Z"),
    ),
    EventLogDb(
        name = "SENT_FROM_SOURCE_BRANCH",
        date = ZonedDateTime.parse("2018-08-18T04:56:07Z"),
    ),
    EventLogDb(
        name = "CONFIRMED",
        date = ZonedDateTime.parse("2018-08-14T04:56:07Z"),
    ),
)
