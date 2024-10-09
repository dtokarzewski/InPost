package pl.inpost.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import pl.inpost.data.datasource.ShipmentLocalDataSource
import pl.inpost.data.datasource.ShipmentRemoteDataSource
import pl.inpost.domain.data.Shipment
import pl.inpost.domain.repository.ShipmentRepository
import javax.inject.Inject

class ShipmentRepositoryImpl @Inject constructor(
    private val remoteDataSource: ShipmentRemoteDataSource,
    private val localDataSource: ShipmentLocalDataSource
) : ShipmentRepository {

    override fun getShipmentsAsFlow(): Flow<List<Shipment>> = localDataSource.getShipmentsAsFlow()

    override suspend fun hideShipment(shipmentNumber: String) {
        withContext(Dispatchers.IO) {
            localDataSource.hideShipment(shipmentNumber)
        }
    }

    override suspend fun refreshShipments() {
        return withContext(Dispatchers.IO) {
            val shipments = remoteDataSource.getShipments()
            localDataSource.saveShipments(shipments)
        }
    }
}
