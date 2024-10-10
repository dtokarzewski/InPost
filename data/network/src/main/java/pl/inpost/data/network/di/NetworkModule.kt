package pl.inpost.data.network.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.inpost.data.datasource.ShipmentRemoteDataSource
import pl.inpost.data.network.typeadapter.ApiTypeAdapter
import pl.inpost.data.network.api.FakeShipmentApi
import pl.inpost.data.network.api.ShipmentApi
import pl.inpost.data.network.datasource.FakeShipmentRemoteDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkModule {

    companion object {
        @Provides
        fun shipmentApi(
            @ApplicationContext context: Context,
            apiTypeAdapter: ApiTypeAdapter
        ): ShipmentApi = FakeShipmentApi(context, apiTypeAdapter)
    }

    @Binds
    abstract fun shipmentRemoteDataSource(
        fakeDtaSource: FakeShipmentRemoteDataSource,
    ): ShipmentRemoteDataSource
}
