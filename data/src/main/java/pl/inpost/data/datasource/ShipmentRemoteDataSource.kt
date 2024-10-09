package pl.inpost.data.datasource

import pl.inpost.domain.data.Shipment

interface ShipmentRemoteDataSource {
    suspend fun getShipments(): Result<List<Shipment>>
}