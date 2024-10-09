package pl.inpost.data.network.api

import pl.inpost.data.network.model.ShipmentNetwork

interface ShipmentApi {
    suspend fun getShipments(): List<ShipmentNetwork>
}
