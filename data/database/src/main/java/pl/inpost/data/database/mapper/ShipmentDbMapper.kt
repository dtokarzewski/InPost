package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.ShipmentDb
import pl.inpost.data.network.mapper.EventLogDbMapper
import pl.inpost.data.network.mapper.ShipmentTypeDbMapper
import pl.inpost.domain.data.Shipment
import javax.inject.Inject

class ShipmentDbMapper @Inject constructor(
    private val customerNetworkMapper: CustomerDbMapper,
    private val eventLogMapper: EventLogDbMapper,
    private val operationsMapper: OperationsDbMapper,
    private val shipmentStatusMapper: ShipmentStatusDbMapper,
    private val shipmentTypeMapper: ShipmentTypeDbMapper,
) {
    fun toDomain(shipmentDb: ShipmentDb) = Shipment(
        number = shipmentDb.number,
        shipmentType = shipmentTypeMapper.toDomain(shipmentDb.shipmentType),
        status = shipmentStatusMapper.toDomain(shipmentDb.status),
        eventLog = shipmentDb.eventLog.map { eventLogMapper.toDomain(it) },
        openCode = shipmentDb.openCode,
        expiryDate = shipmentDb.expiryDate,
        storedDate = shipmentDb.storedDate,
        pickUpDate = shipmentDb.pickUpDate,
        receiver = shipmentDb.receiver?.let { customerNetworkMapper.toDomain(it) },
        sender = shipmentDb.sender?.let { customerNetworkMapper.toDomain(it) },
        operations = operationsMapper.toDomain(shipmentDb.operations),
    )
}