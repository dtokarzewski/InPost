package pl.inpost.common.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

const val PRESENTATION_DATE_PATTERN = "EEE. | dd.MM.yy | HH:mm"

fun ZonedDateTime.toPresentationString(): String {
    // TODO hardcoded locale - use Locale.getDefault() when other languages are supported
    val formatter = DateTimeFormatter.ofPattern(PRESENTATION_DATE_PATTERN, Locale.US)
    return this.format(formatter)
}