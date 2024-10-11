package pl.inpost.data.database.typeconventer

import androidx.room.TypeConverter
import java.time.ZonedDateTime

internal class ZonedDateTimeConverter {
    @TypeConverter
    fun stringToZonedDateTime(value: String?): ZonedDateTime? {
        return value?.let { ZonedDateTime.parse(it) }
    }

    @TypeConverter
    fun zonedDateTimeToString(zonedDateTime: ZonedDateTime?): String? {
        return zonedDateTime?.toString()
    }
}