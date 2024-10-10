package pl.inpost.data.network.mapper

import pl.inpost.data.database.model.ShipmentTypeDb
import pl.inpost.domain.data.ShipmentType
import javax.inject.Inject

class ShipmentTypeDbMapper @Inject constructor() {
    fun toDomain(network: ShipmentTypeDb) = when (network) {
        ShipmentTypeDb.PARCEL_LOCKER -> ShipmentType.PARCEL_LOCKER
        ShipmentTypeDb.COURIER -> ShipmentType.COURIER
    }

}