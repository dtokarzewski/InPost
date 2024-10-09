package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.ShipmentTypeNetwork
import pl.inpost.domain.data.ShipmentType
import javax.inject.Inject

class ShipmentTypeNetworkMapper @Inject constructor() {
    fun toDomain(network: ShipmentTypeNetwork) = when (network) {
        ShipmentTypeNetwork.PARCEL_LOCKER -> ShipmentType.PARCEL_LOCKER
        ShipmentTypeNetwork.COURIER -> ShipmentType.COURIER
    }

}