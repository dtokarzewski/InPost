package pl.inpost.domain.model

import java.time.ZonedDateTime

data class EventLog(
    val name: String,
    val date: ZonedDateTime
)
