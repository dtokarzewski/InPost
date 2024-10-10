package pl.inpost.data.database.datasource

import kotlinx.coroutines.flow.Flow
import pl.inpost.data.datasource.ShipmentLocalDataSource
import pl.inpost.domain.data.Shipment
import javax.inject.Inject

class RoomShipmentLocalDataSource @Inject constructor(
) : ShipmentLocalDataSource {
    override fun getShipmentsAsFlow(): Flow<List<Shipment>> {
        TODO("Not yet implemented")
    }

    override suspend fun hideShipment(shipmentNumber: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveShipments(shipments: List<Shipment>) {
        TODO("Not yet implemented")
    }
}