package pl.inpost.data.repository

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.datasource.ShipmentLocalDataSource
import pl.inpost.data.datasource.ShipmentRemoteDataSource
import pl.inpost.domain.data.testdata.shipmentsTestData
import java.io.IOException

class ShipmentRepositoryImplTest {
    private lateinit var sut: ShipmentRepositoryImpl
    private val remoteDataSource = mockk<ShipmentRemoteDataSource>()
    private val localDataSource = mockk<ShipmentLocalDataSource>()

    @Before
    fun setUp() {
        sut = ShipmentRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Test
    fun `GIVEN repository WHEN getShipmentsAsFlow called and data source returns success THEN return flow result`() = runTest {
        every { localDataSource.getShipmentsAsFlow() } returns flowOf(shipmentsTestData())

        val expected = shipmentsTestData()

        sut.getShipmentsAsFlow().test {
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test(expected = IOException::class)
    fun `GIVEN repository WHEN getShipmentsAsFlow called and data source throws exception THEN rethrow exception`() = runTest {
        every { localDataSource.getShipmentsAsFlow() } throws IOException("Failed to get shipments")

        sut.getShipmentsAsFlow()
    }

    @Test
    fun `GIVEN repository WHEN hideShipment called THEN call localDataSource hideShipment`() = runTest {
        coJustRun { localDataSource.hideShipment(any()) }

        sut.hideShipment("123")

        coVerify(exactly = 1) { localDataSource.hideShipment("123") }
    }

    @Test(expected = IOException::class)
    fun `GIVEN repository WHEN hideShipment called and localDataSource throws exception THEN rethrow exception`() = runTest {
        coEvery { localDataSource.hideShipment(any()) } throws IOException("Failed to hide shipment")

        sut.hideShipment("123")
    }

    @Test
    fun `GIVEN repository WHEN refreshShipments called and remoteDataSource returns success THEN return success result`() = runTest {
        coEvery { remoteDataSource.getShipments() } returns shipmentsTestData()
        coJustRun { localDataSource.saveShipments(any()) }

        val result = sut.refreshShipments()

        assertEquals(Unit, result)

        coVerify(exactly = 1) { remoteDataSource.getShipments() }
        coVerify(exactly = 1) { localDataSource.saveShipments(shipmentsTestData()) }
    }

    @Test(expected = IOException::class)
    fun `GIVEN repository WHEN refreshShipments called and remoteDataSource returns failure THEN return failure result`() = runTest {
        val exception = IOException("Failed to refresh shipments")
        coEvery { remoteDataSource.getShipments() } throws  exception

        sut.refreshShipments()
    }

    @Test(expected = IOException::class)
    fun `GIVEN repository WHEN refreshShipments called and localDataSource throws exception THEN return failure result`() = runTest {
        val exception = IOException("Failed to save shipments")
        coEvery { remoteDataSource.getShipments() } returns shipmentsTestData()
        coEvery { localDataSource.saveShipments(any()) } throws exception

        sut.refreshShipments()
    }
}
