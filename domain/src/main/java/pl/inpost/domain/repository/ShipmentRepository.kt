package pl.inpost.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.inpost.domain.data.Shipment

interface ShipmentRepository {
    fun getHighlightedShipmentsAsFlow(): Flow<List<Shipment>>
    fun getStandardShipmentsAsFlow(): Flow<List<Shipment>>
    fun hideShipment(shipmentNumber: String)
}
