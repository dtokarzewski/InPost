package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.ShipmentNetwork
import pl.inpost.domain.data.Shipment
import pl.inpost.domain.data.ShipmentStatus
import javax.inject.Inject

class ShipmentNetworkMapper @Inject constructor(
    private val customerNetworkMapper: CustomerNetworkMapper,
    private val eventLogNetworkMapper: EventLogNetworkMapper,
    private val operationsNetworkMapper: OperationsNetworkMapper,
    private val shipmentStatusNetworkMapper: ShipmentStatusNetworkMapper,
    private val shipmentTypeNetworkMapper: ShipmentTypeNetworkMapper,
) {
    fun toDomain(shipmentNetwork: ShipmentNetwork) = Shipment(
        number = shipmentNetwork.number,
        shipmentType = shipmentTypeNetworkMapper.toDomain(shipmentNetwork.shipmentType),
        status = shipmentNetwork.status?.let { shipmentStatusNetworkMapper.toDomain(it) }
            ?: ShipmentStatus.OTHER,
        eventLog = shipmentNetwork.eventLog.map { eventLogNetworkMapper.toDomain(it) },
        openCode = shipmentNetwork.openCode,
        expiryDate = shipmentNetwork.expiryDate,
        storedDate = shipmentNetwork.storedDate,
        pickUpDate = shipmentNetwork.pickUpDate,
        receiver = shipmentNetwork.receiver?.let { customerNetworkMapper.toDomain(it) },
        sender = shipmentNetwork.sender?.let { customerNetworkMapper.toDomain(it) },
        operations = operationsNetworkMapper.toDomain(shipmentNetwork.operations),
    )
}