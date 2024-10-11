package pl.inpost.data.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class PopulatedShipmentDb(
    @Embedded val shipment: ShipmentDb,
    @Relation(
        parentColumn = "shipmentNumber",
        entityColumn = "shipmentNumber"
    )
    val eventLog: List<EventLogDb>,
    @Relation(
        parentColumn = "senderId",
        entityColumn = "customerId",
    )
    val sender: CustomerDb?,
    @Relation(
        parentColumn = "receiverId",
        entityColumn = "customerId",
    )
    val receiver: CustomerDb?,
) {
}