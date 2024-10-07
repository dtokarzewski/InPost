package pl.inpost.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.inpost.domain.data.Shipment

interface ShipmentRepository {
    fun getShipmentsAsFlow(): Flow<List<Shipment>>
    fun hideShipment(shipmentNumber: String)
}
