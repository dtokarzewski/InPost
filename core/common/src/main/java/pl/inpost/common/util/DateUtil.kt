package pl.inpost.common.util

import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.util.Locale

const val PRESENTATION_DATE_PATTERN = "EEE. | dd.MM.yy | HH:mm"

fun ZonedDateTime.toPresentationString(): String {
    val formatter = SimpleDateFormat(PRESENTATION_DATE_PATTERN, Locale.getDefault())
    return formatter.format(this)
}