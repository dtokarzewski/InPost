package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.ShipmentStatusNetwork
import pl.inpost.domain.data.ShipmentStatus
import javax.inject.Inject

class ShipmentStatusNetworkMapper @Inject constructor() {
    fun toDomain(status: ShipmentStatusNetwork) = when (status) {
        ShipmentStatusNetwork.ADOPTED_AT_SORTING_CENTER -> ShipmentStatus.ADOPTED_AT_SORTING_CENTER
        ShipmentStatusNetwork.SENT_FROM_SORTING_CENTER -> ShipmentStatus.SENT_FROM_SORTING_CENTER
        ShipmentStatusNetwork.ADOPTED_AT_SOURCE_BRANCH -> ShipmentStatus.ADOPTED_AT_SOURCE_BRANCH
        ShipmentStatusNetwork.SENT_FROM_SOURCE_BRANCH -> ShipmentStatus.SENT_FROM_SOURCE_BRANCH
        ShipmentStatusNetwork.AVIZO -> ShipmentStatus.AVIZO
        ShipmentStatusNetwork.CONFIRMED -> ShipmentStatus.CONFIRMED
        ShipmentStatusNetwork.CREATED -> ShipmentStatus.CREATED
        ShipmentStatusNetwork.DELIVERED -> ShipmentStatus.DELIVERED
        ShipmentStatusNetwork.OTHER -> ShipmentStatus.OTHER
        ShipmentStatusNetwork.OUT_FOR_DELIVERY -> ShipmentStatus.OUT_FOR_DELIVERY
        ShipmentStatusNetwork.PICKUP_TIME_EXPIRED -> ShipmentStatus.PICKUP_TIME_EXPIRED
        ShipmentStatusNetwork.READY_TO_PICKUP -> ShipmentStatus.READY_TO_PICKUP
        ShipmentStatusNetwork.RETURNED_TO_SENDER -> ShipmentStatus.RETURNED_TO_SENDER
    }
}