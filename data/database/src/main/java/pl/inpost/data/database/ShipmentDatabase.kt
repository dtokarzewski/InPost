package pl.inpost.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.inpost.data.database.dao.CustomerDao
import pl.inpost.data.database.dao.EventLogDao
import pl.inpost.data.database.dao.ShipmentDao
import pl.inpost.data.database.model.CustomerDb
import pl.inpost.data.database.model.EventLogDb
import pl.inpost.data.database.model.ShipmentDb
import pl.inpost.data.database.typeconventer.ZonedDateTimeConverter

@Database(
    entities = [
        ShipmentDb::class,
        CustomerDb::class,
        EventLogDb::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    ZonedDateTimeConverter::class,
)
abstract class ShipmentDatabase : RoomDatabase() {
    abstract fun shipmentDao(): ShipmentDao
    abstract fun customerDao(): CustomerDao
    abstract fun eventLogDao(): EventLogDao

}