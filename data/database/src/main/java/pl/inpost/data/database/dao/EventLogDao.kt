package pl.inpost.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import pl.inpost.data.database.model.EventLogDb

@Dao
interface EventLogDao {

    @Upsert
    suspend fun upsert(eventLog: EventLogDb)

    @Upsert
    suspend fun upsertAll(eventLogs: List<EventLogDb>)

    @Query("SELECT * FROM event_log WHERE shipmentNumber = :shipmentNumber")
    fun getEventLogsForShipment(shipmentNumber: String): Flow<List<EventLogDb>>

    @Query("SELECT * FROM event_log WHERE id = :id")
    fun getEventLog(id: Int): Flow<EventLogDb>
}