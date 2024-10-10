package pl.inpost.data.database.model

import pl.inpost.data.network.model.EventLogDb
import java.time.ZonedDateTime

data class ShipmentDb(
    val number: String,
    val shipmentType: ShipmentTypeDb,
    val status: ShipmentStatusDb,
    val eventLog: List<EventLogDb>,
    val openCode: String?,
    val expiryDate: ZonedDateTime?,
    val storedDate: ZonedDateTime?,
    val pickUpDate: ZonedDateTime?,
    val receiver: CustomerDb?,
    val sender: CustomerDb?,
    val operations: OperationsDb
)
