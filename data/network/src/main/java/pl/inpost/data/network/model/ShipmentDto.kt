package pl.inpost.data.network.model

import java.time.ZonedDateTime

data class ShipmentDto(
    val number: String,
    val shipmentType: String,
    val status: String,
    val eventLog: List<EventLogDto>,
    val openCode: String?,
    val expiryDate: ZonedDateTime?,
    val storedDate: ZonedDateTime?,
    val pickUpDate: ZonedDateTime?,
    val receiver: CustomerDto?,
    val sender: CustomerDto?,
    val operations: OperationsDto
)
