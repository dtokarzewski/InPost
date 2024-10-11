package pl.inpost.data.database.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(
    tableName = "event_log",
    indices = [Index(value = ["shipmentNumber"]), Index(value = ["shipmentNumber", "date"], unique = true)]
)
data class EventLogDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val date: ZonedDateTime,
    val shipmentNumber: String,
)
