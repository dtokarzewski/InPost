package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.PopulatedShipmentDb
import pl.inpost.data.database.model.ShipmentDb
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
    fun toDomain(populatedShipmentDb: PopulatedShipmentDb) = with(populatedShipmentDb.shipment) {
        Shipment(
            number = shipmentNumber,
            shipmentType = shipmentTypeMapper.toDomain(shipmentType),
            status = shipmentStatusMapper.toDomain(status),
            eventLog = populatedShipmentDb.eventLog.map { eventLogMapper.toDomain(it) },
            openCode = openCode,
            expiryDate = expiryDate,
            storedDate = storedDate,
            pickUpDate = pickUpDate,
            receiver = populatedShipmentDb.receiver?.let { customerNetworkMapper.toDomain(it) },
            sender = populatedShipmentDb.sender?.let { customerNetworkMapper.toDomain(it) },
            isHidden = isHidden,
            operations = operationsMapper.toDomain(operations),
        )
    }

    fun toEntity(shipment: Shipment) = with(shipment) {
        ShipmentDb(
            shipmentNumber = number,
            shipmentType = shipmentTypeMapper.toEntity(shipmentType),
            status = shipmentStatusMapper.toEntity(status),
            openCode = openCode,
            expiryDate = expiryDate,
            storedDate = storedDate,
            pickUpDate = pickUpDate,
            receiverId = 0,
            senderId = 0,
            isHidden = isHidden,
            operations = operationsMapper.toEntity(operations),
        )
    }
}