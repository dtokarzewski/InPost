package pl.inpost.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import pl.inpost.data.database.model.PopulatedShipmentDb
import pl.inpost.data.database.model.ShipmentDb

@Dao
interface ShipmentDao {

    @Upsert
    suspend fun upsert(shipment: ShipmentDb): Long

    @Upsert
    suspend fun upsertAll(shipments: List<ShipmentDb>): List<Long>

    @Query("SELECT isHidden FROM shipment WHERE shipmentNumber = :shipmentNumber")
    fun verifyIfShipmentIsHidden(shipmentNumber: String): Boolean?

    @Transaction
    @Query("SELECT * FROM shipment")
    fun getAllPopulatedShipments(): Flow<List<PopulatedShipmentDb>>

    @Transaction
    @Query("SELECT * FROM shipment WHERE isHidden = 0 ORDER BY operations_highlight DESC, status DESC, pickUpDate ASC, expiryDate ASC, storedDate ASC, shipmentNumber ASC")
    fun getAllUnhiddenPopulatedShipments(): Flow<List<PopulatedShipmentDb>>

    @Query("UPDATE shipment SET isHidden = 1 WHERE shipmentNumber = :shipmentNumber")
    suspend fun hideShipment(shipmentNumber: String)

}