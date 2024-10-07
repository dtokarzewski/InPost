package pl.inpost.shipmentlist.data.mapper

import pl.inpost.domain.model.ShipmentStatus
import pl.inpost.shipmentlist.data.data.ShipmentStatusUi
import javax.inject.Inject

class ShipmentStatusUiMapper @Inject constructor() {
    fun toUi(status: ShipmentStatus) = when (status) {
        ShipmentStatus.ADOPTED_AT_SORTING_CENTER -> ShipmentStatusUi.ADOPTED_AT_SORTING_CENTER
        ShipmentStatus.SENT_FROM_SORTING_CENTER -> ShipmentStatusUi.SENT_FROM_SORTING_CENTER
        ShipmentStatus.ADOPTED_AT_SOURCE_BRANCH -> ShipmentStatusUi.ADOPTED_AT_SOURCE_BRANCH
        ShipmentStatus.SENT_FROM_SOURCE_BRANCH -> ShipmentStatusUi.SENT_FROM_SOURCE_BRANCH
        ShipmentStatus.AVIZO -> ShipmentStatusUi.AVIZO
        ShipmentStatus.CONFIRMED -> ShipmentStatusUi.CONFIRMED
        ShipmentStatus.CREATED -> ShipmentStatusUi.CREATED
        ShipmentStatus.DELIVERED -> ShipmentStatusUi.DELIVERED
        ShipmentStatus.OTHER -> ShipmentStatusUi.OTHER
        ShipmentStatus.OUT_FOR_DELIVERY -> ShipmentStatusUi.OUT_FOR_DELIVERY
        ShipmentStatus.PICKUP_TIME_EXPIRED -> ShipmentStatusUi.PICKUP_TIME_EXPIRED
        ShipmentStatus.READY_TO_PICKUP -> ShipmentStatusUi.READY_TO_PICKUP
        ShipmentStatus.RETURNED_TO_SENDER -> ShipmentStatusUi.RETURNED_TO_SENDER
    }
}
