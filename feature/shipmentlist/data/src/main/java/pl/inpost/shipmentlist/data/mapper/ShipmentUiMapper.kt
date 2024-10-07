package pl.inpost.shipmentlist.data.mapper

import pl.inpost.common.util.toPresentationString
import pl.inpost.shipmentlist.data.data.ShipmentUi
import pl.inpost.domain.model.Shipment
import pl.inpost.domain.model.ShipmentStatus
import pl.inpost.shipmentlist.data.data.ShipmentDisplayDateTypeUi
import javax.inject.Inject

class ShipmentUiMapper @Inject constructor(
    private val shipmentTypeUiMapper: ShipmentTypeUiMapper,
    private val shipmentStatusUiMapper: ShipmentStatusUiMapper,
    private val customerUiMapper: CustomerUiMapper,
    private val operationsUiMapper: OperationsUiMapper,
) {

    fun toUi(shipment: Shipment): ShipmentUi {
        return ShipmentUi(
            number = shipment.number,
            shipmentType = shipmentTypeUiMapper.toUi(shipment.shipmentType),
            status = shipmentStatusUiMapper.toUi(shipment.status),
            expiryDate = shipment.expiryDate?.toPresentationString(),
            storedDate = shipment.storedDate?.toPresentationString(),
            pickUpDate = shipment.pickUpDate?.toPresentationString(),
            dateDisplayType = resolveDisplayDateType(shipment),
            receiver = shipment.receiver?.let { customerUiMapper.toUi(it) },
            sender = shipment.sender?.let { customerUiMapper.toUi(it) },
            operations = operationsUiMapper.toUi(shipment.operations),
        )
    }

    private fun resolveDisplayDateType(shipment: Shipment): ShipmentDisplayDateTypeUi = with(shipment) {
        when {
            status == ShipmentStatus.DELIVERED && pickUpDate != null -> ShipmentDisplayDateTypeUi.PICKUP_DATE
            status == ShipmentStatus.READY_TO_PICKUP && expiryDate != null -> ShipmentDisplayDateTypeUi.EXPIRY_DATE
            else -> ShipmentDisplayDateTypeUi.NONE
        }
    }
}
