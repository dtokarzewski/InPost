package pl.inpost.data.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(
    tableName = "shipment",
)
data class ShipmentDb(
    @PrimaryKey
    val shipmentNumber: String,
    val shipmentType: ShipmentTypeDb,
    val status: ShipmentStatusDb,
    val openCode: String?,
    val expiryDate: ZonedDateTime?,
    val storedDate: ZonedDateTime?,
    val pickUpDate: ZonedDateTime?,
    val receiverId: Long?,
    val senderId: Long?,
    val isHidden: Boolean,
    @Embedded(prefix = "operations_")
    val operations: OperationsDb,
)
