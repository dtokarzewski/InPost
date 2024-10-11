package pl.inpost.data.datasource

import kotlinx.coroutines.flow.Flow
import pl.inpost.domain.data.Shipment

interface ShipmentLocalDataSource {
    fun getUnhiddenShipmentsAsFlow(): Flow<List<Shipment>>
    suspend fun hideShipment(shipmentNumber: String)
    suspend fun saveShipments(shipments: List<Shipment>)
}