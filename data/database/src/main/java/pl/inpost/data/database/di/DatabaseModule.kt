package pl.inpost.data.database.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.inpost.data.database.datasource.RoomShipmentLocalDataSource
import pl.inpost.data.datasource.ShipmentLocalDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModule {

    @Binds
    abstract fun bindLocalDataSource(
        dataSource: RoomShipmentLocalDataSource
    ): ShipmentLocalDataSource
}