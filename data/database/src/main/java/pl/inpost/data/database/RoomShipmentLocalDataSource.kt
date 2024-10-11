package pl.inpost.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import pl.inpost.data.database.dao.CustomerDao
import pl.inpost.data.database.dao.EventLogDao
import pl.inpost.data.database.dao.ShipmentDao
import pl.inpost.data.database.mapper.CustomerDbMapper
import pl.inpost.data.database.mapper.EventLogDbMapper
import pl.inpost.data.database.mapper.ShipmentDbMapper
import pl.inpost.data.datasource.ShipmentLocalDataSource
import pl.inpost.domain.data.Shipment
import javax.inject.Inject

class RoomShipmentLocalDataSource @Inject constructor(
    private val shipmentDao: ShipmentDao,
    private val customerDao: CustomerDao,
    private val eventLogDao: EventLogDao,
    private val shipmentDbMapper: ShipmentDbMapper,
    private val eventLogMapper: EventLogDbMapper,
    private val customerDbMapper: CustomerDbMapper,
) : ShipmentLocalDataSource {
    override fun getUnhiddenShipmentsAsFlow(): Flow<List<Shipment>> =
        shipmentDao
            .getAllUnhiddenPopulatedShipments()
            .map { shipments -> shipments.map { shipmentDbMapper.toDomain(it) } }

    override suspend fun hideShipment(shipmentNumber: String) {
        withContext(Dispatchers.IO) {
            shipmentDao.hideShipment(shipmentNumber)
        }
    }

    override suspend fun saveShipments(shipments: List<Shipment>) {
        withContext(Dispatchers.IO) {
            shipments.forEach { shipment ->
                val senderDb = shipment.sender?.let { customerDbMapper.toEntity(it) }
                val senderId = senderDb?.let { customerDao.upsert(it) } ?: 0

                val receiverDb = shipment.receiver?.let { customerDbMapper.toEntity(it) }
                val receiverId = receiverDb?.let { customerDao.upsert(it) } ?: 0

                var shipmentDb = shipmentDbMapper.toEntity(shipment)

                /* Update isHidden flag with value from DB. API doesn't return this value, so domain
                *  model always return false, after network -> domain model mapping. */
                val isHidden = shipmentDao.verifyIfShipmentIsHidden(shipment.number)
                shipmentDb = shipmentDb.copy(isHidden = isHidden ?: false)

                shipmentDb = shipmentDb.copy(
                    senderId = senderId,
                    receiverId = receiverId,
                )
                shipmentDao.upsert(shipmentDb)

                val eventLogs = eventLogMapper.toEntity(shipment.eventLog, shipment.number)
                eventLogDao.upsertAll(eventLogs)
            }
        }
    }
}