package pl.inpost.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.inpost.data.repository.ShipmentRepositoryImpl
import pl.inpost.domain.repository.ShipmentRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindShipmentRepository(impl: ShipmentRepositoryImpl): ShipmentRepository
}