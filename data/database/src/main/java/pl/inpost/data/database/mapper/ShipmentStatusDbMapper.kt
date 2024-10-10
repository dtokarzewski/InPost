package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.ShipmentStatusDb
import pl.inpost.domain.data.ShipmentStatus
import javax.inject.Inject

class ShipmentStatusDbMapper @Inject constructor() {
    fun toDomain(status: ShipmentStatusDb) = when (status) {
        ShipmentStatusDb.ADOPTED_AT_SORTING_CENTER -> ShipmentStatus.ADOPTED_AT_SORTING_CENTER
        ShipmentStatusDb.SENT_FROM_SORTING_CENTER -> ShipmentStatus.SENT_FROM_SORTING_CENTER
        ShipmentStatusDb.ADOPTED_AT_SOURCE_BRANCH -> ShipmentStatus.ADOPTED_AT_SOURCE_BRANCH
        ShipmentStatusDb.SENT_FROM_SOURCE_BRANCH -> ShipmentStatus.SENT_FROM_SOURCE_BRANCH
        ShipmentStatusDb.AVIZO -> ShipmentStatus.AVIZO
        ShipmentStatusDb.CONFIRMED -> ShipmentStatus.CONFIRMED
        ShipmentStatusDb.CREATED -> ShipmentStatus.CREATED
        ShipmentStatusDb.DELIVERED -> ShipmentStatus.DELIVERED
        ShipmentStatusDb.OTHER -> ShipmentStatus.OTHER
        ShipmentStatusDb.OUT_FOR_DELIVERY -> ShipmentStatus.OUT_FOR_DELIVERY
        ShipmentStatusDb.PICKUP_TIME_EXPIRED -> ShipmentStatus.PICKUP_TIME_EXPIRED
        ShipmentStatusDb.READY_TO_PICKUP -> ShipmentStatus.READY_TO_PICKUP
        ShipmentStatusDb.RETURNED_TO_SENDER -> ShipmentStatus.RETURNED_TO_SENDER
    }
}