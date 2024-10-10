package pl.inpost.data.network.datasource

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.api.ShipmentApi
import pl.inpost.data.network.mapper.CustomerNetworkMapper
import pl.inpost.data.network.mapper.EventLogNetworkMapper
import pl.inpost.data.network.mapper.OperationsNetworkMapper
import pl.inpost.data.network.mapper.ShipmentNetworkMapper
import pl.inpost.data.network.mapper.ShipmentStatusNetworkMapper
import pl.inpost.data.network.mapper.ShipmentTypeNetworkMapper
import pl.inpost.data.network.model.testdata.shipmentsNetworkTestData
import pl.inpost.domain.data.testdata.shipmentsTestData
import java.io.IOException

class FakeShipmentRemoteDataSourceTest {
    private lateinit var sut: FakeShipmentRemoteDataSource
    private val shipmentApi = mockk<ShipmentApi>()
    private val shipmentNetworkMapper = ShipmentNetworkMapper(
        customerNetworkMapper = CustomerNetworkMapper(),
        eventLogNetworkMapper = EventLogNetworkMapper(),
        operationsNetworkMapper = OperationsNetworkMapper(),
        shipmentStatusNetworkMapper = ShipmentStatusNetworkMapper(),
        shipmentTypeNetworkMapper = ShipmentTypeNetworkMapper(),
    )

    @Before
    fun setUp() {
        sut = FakeShipmentRemoteDataSource(shipmentApi, shipmentNetworkMapper)
    }

    @Test
    fun `GIVEN fake data source WHEN getShipments with successful api response THEN return shipments`() = runTest {
        coEvery { shipmentApi.getShipments() } returns shipmentsNetworkTestData()

        val result = sut.getShipments()

        assertEquals(shipmentsTestData(), result)
    }

    @Test(expected = IOException::class)
    fun `GIVEN fake data source WHEN getShipments with failed api response THEN throw exception`() = runTest {
        coEvery { shipmentApi.getShipments() } throws IOException("API error")

        sut.getShipments()
    }
}