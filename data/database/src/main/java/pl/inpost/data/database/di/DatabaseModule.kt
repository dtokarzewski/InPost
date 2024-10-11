package pl.inpost.data.database.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.inpost.data.database.RoomShipmentLocalDataSource
import pl.inpost.data.database.ShipmentDatabase
import pl.inpost.data.database.dao.CustomerDao
import pl.inpost.data.database.dao.EventLogDao
import pl.inpost.data.database.dao.ShipmentDao
import pl.inpost.data.datasource.ShipmentLocalDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModule {

    @Provides
    fun provideCustomerDao(database: ShipmentDatabase): CustomerDao = database.customerDao()

    @Provides
    fun provideEventLogDao(database: ShipmentDatabase): EventLogDao = database.eventLogDao()

    @Provides
    fun provideShipmentDao(database: ShipmentDatabase): ShipmentDao = database.shipmentDao()

    @Binds
    abstract fun bindLocalDataSource(
        dataSource: RoomShipmentLocalDataSource
    ): ShipmentLocalDataSource
}