package pl.inpost.data.repository

import kotlinx.coroutines.flow.Flow
import pl.inpost.domain.data.Shipment
import pl.inpost.domain.repository.ShipmentRepository
import javax.inject.Inject

class ShipmentRepositoryImpl @Inject constructor() : ShipmentRepository {

    override fun getShipmentsAsFlow(): Flow<List<Shipment>> {
        TODO("Not yet implemented")
    }

    override suspend fun hideShipment(shipmentNumber: String) {
        TODO("Not yet implemented")
    }

    override suspend fun refreshShipments(): Result<Unit> {
        TODO("Not yet implemented")
    }
}
