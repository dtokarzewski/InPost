package pl.inpost.shipmentlist.data.mapper

import javax.inject.Inject
import pl.inpost.domain.data.ShipmentType
import pl.inpost.shipmentlist.data.model.ShipmentTypeUi

class ShipmentTypeUiMapper @Inject constructor() {
    fun toUi(shipmentType: ShipmentType) = when (shipmentType) {
        ShipmentType.PARCEL_LOCKER -> ShipmentTypeUi.PARCEL_LOCKER
        ShipmentType.COURIER -> ShipmentTypeUi.COURIER
    }
}