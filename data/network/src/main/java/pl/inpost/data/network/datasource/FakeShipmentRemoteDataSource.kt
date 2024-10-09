package pl.inpost.data.network.datasource

import pl.inpost.data.datasource.ShipmentRemoteDataSource
import pl.inpost.data.network.api.ShipmentApi
import pl.inpost.data.network.mapper.ShipmentNetworkMapper
import pl.inpost.domain.data.Shipment
import javax.inject.Inject

class FakeShipmentRemoteDataSource @Inject constructor(
    private val shipmentApi: ShipmentApi,
    private val shipmentNetworkMapper: ShipmentNetworkMapper,
) : ShipmentRemoteDataSource {
    override suspend fun getShipments(): List<Shipment> {
        return shipmentApi.getShipments().map { shipmentNetworkMapper.toDomain(it) }
    }
}
