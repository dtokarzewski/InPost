package pl.inpost.domain.data.testdata

import pl.inpost.domain.data.EventLog
import java.time.ZonedDateTime

fun eventLogTestData() = listOf(
    EventLog(
        name = "READY_TO_PICKUP",
        date = ZonedDateTime.parse("2018-08-01T04:56:07Z"),
    ),
    EventLog(
        name = "SENT_FROM_SOURCE_BRANCH",
        date = ZonedDateTime.parse("2018-08-18T04:56:07Z"),
    ),
    EventLog(
        name = "CONFIRMED",
        date = ZonedDateTime.parse("2018-08-14T04:56:07Z"),
    ),
)