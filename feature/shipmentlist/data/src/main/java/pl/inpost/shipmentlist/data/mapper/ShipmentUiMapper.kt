package pl.inpost.shipmentlist.data.mapper

import pl.inpost.common.util.toPresentationString
import pl.inpost.shipmentlist.data.model.ShipmentUi
import pl.inpost.domain.data.Shipment
import pl.inpost.domain.data.ShipmentStatus
import pl.inpost.shipmentlist.data.model.ShipmentDisplayDateTypeUi
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
            expiryDate = shipment.expiryDate?.toPresentationString()?.lowercase(),
            storedDate = shipment.storedDate?.toPresentationString()?.lowercase(),
            pickUpDate = shipment.pickUpDate?.toPresentationString()?.lowercase(),
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
            status == ShipmentStatus.PICKUP_TIME_EXPIRED && expiryDate != null -> ShipmentDisplayDateTypeUi.EXPIRY_DATE
            else -> ShipmentDisplayDateTypeUi.NONE
        }
    }
}
