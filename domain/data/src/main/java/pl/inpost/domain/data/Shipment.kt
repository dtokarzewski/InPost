package pl.inpost.domain.data

import java.time.ZonedDateTime

data class Shipment(
    val number: String,
    val shipmentType: ShipmentType,
    val status: ShipmentStatus,
    val eventLog: List<EventLog>,
    val openCode: String?,
    val expiryDate: ZonedDateTime?,
    val storedDate: ZonedDateTime?,
    val pickUpDate: ZonedDateTime?,
    val receiver: Customer?,
    val sender: Customer?,
    val isHidden: Boolean,
    val operations: Operations
)
