package pl.inpost.data.database

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.inpost.core.test.MainDispatcherRule
import pl.inpost.data.database.dao.CustomerDao
import pl.inpost.data.database.dao.EventLogDao
import pl.inpost.data.database.dao.ShipmentDao
import pl.inpost.data.database.mapper.CustomerDbMapper
import pl.inpost.data.database.mapper.EventLogDbMapper
import pl.inpost.data.database.mapper.ShipmentDbMapper
import pl.inpost.data.database.testdata.eventLogDbTestData
import pl.inpost.data.database.testdata.populatedShipmentDbTestData
import pl.inpost.data.database.testdata.receiverDbTestData
import pl.inpost.data.database.testdata.senderDbTestData
import pl.inpost.data.database.testdata.shipmentDbTestData
import pl.inpost.domain.data.testdata.eventLogTestData
import pl.inpost.domain.data.testdata.receiverTestData
import pl.inpost.domain.data.testdata.senderTestData
import pl.inpost.domain.data.testdata.shipmentTestData
import java.io.IOException

class RoomShipmentLocalDataSourceTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var sut: RoomShipmentLocalDataSource

    private val shipmentDao = mockk<ShipmentDao>()
    private val customerDao = mockk<CustomerDao>()
    private val eventLogDao = mockk<EventLogDao>()
    private val shipmentDbMapper = mockk<ShipmentDbMapper>()
    private val customerDbMapper = mockk<CustomerDbMapper>()
    private val eventLogDbMapper = mockk<EventLogDbMapper>()

    @Before
    fun setUp() {
        sut = RoomShipmentLocalDataSource(
            shipmentDao = shipmentDao,
            customerDao = customerDao,
            eventLogDao = eventLogDao,
            shipmentDbMapper = shipmentDbMapper,
            customerDbMapper = customerDbMapper,
            eventLogMapper = eventLogDbMapper
        )
    }

    @Test
    fun `GIVEN local data source WHEN getUnhiddenShipmentsAsFlow THEN return shipments`() = runTest {
        val populatedShipmentDb = listOf(populatedShipmentDbTestData())
        every { shipmentDao.getAllUnhiddenPopulatedShipments() } returns flowOf(populatedShipmentDb)
        val shipment = shipmentTestData()
        every { shipmentDbMapper.toDomain(any()) } returns shipment

        sut.getUnhiddenShipmentsAsFlow().test {
            assertEquals(listOf(shipment), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test(expected = IOException::class)
    fun `GIVEN local data source WHEN getUnhiddenShipmentsAsFlow with DB error result THEN throw exception`() = runTest {
        every { shipmentDao.getAllUnhiddenPopulatedShipments() } throws IOException("DB error")
        val shipment = shipmentTestData()
        every { shipmentDbMapper.toDomain(any()) } returns shipment

        sut.getUnhiddenShipmentsAsFlow()
    }

    @Test
    fun `GIVEN local data source WHEN getUnhiddenShipmentsAsFlow with mapper error result THEN throw exception`() = runTest {
        val populatedShipmentDb = listOf(populatedShipmentDbTestData())
        every { shipmentDao.getAllUnhiddenPopulatedShipments() } returns flowOf(populatedShipmentDb)
        every { shipmentDbMapper.toDomain(any()) } throws NullPointerException("Mapper error")

        sut.getUnhiddenShipmentsAsFlow().test {
            awaitError() is NullPointerException
        }
    }


    @Test
    fun `GIVEN local data source WHEN hideShipment THEN hide shipment in DB`() = runTest {
        coEvery { shipmentDao.hideShipment(any()) } returns Unit

        sut.hideShipment("123")

        coVerify { shipmentDao.hideShipment("123") }
    }

    @Test(expected = IOException::class)
    fun `GIVEN local data source WHEN hideShipment with DB error THEN throw exception`() = runTest {
        coEvery { shipmentDao.hideShipment(any()) } throws IOException("Db error")

        sut.hideShipment("123")
    }

    @Test
    fun `GIVEN local data source WHEN saveShipments THEN save shipments in DB`() = runTest {
        val shipment = shipmentTestData()
        val shipmentDb = shipmentDbTestData()

        every { shipmentDbMapper.toEntity(any()) } returns shipmentDb
        every { customerDbMapper.toEntity(senderTestData()) } returns senderDbTestData()
        every { customerDbMapper.toEntity(receiverTestData()) } returns receiverDbTestData()
        every { eventLogDbMapper.toEntity(
            eventLog = eventLogTestData(),
            shipmentNumber = shipment.number)
        } returns eventLogDbTestData()
        coEvery { shipmentDao.upsert(any()) } returns 1
        coEvery { customerDao.upsert(senderDbTestData()) } returns 2
        coEvery { customerDao.upsert(receiverDbTestData()) } returns 1
        coEvery { eventLogDao.upsertAll(any()) } returns Unit
        coEvery { shipmentDao.verifyIfShipmentIsHidden(any()) } returns false

        sut.saveShipments(listOf(shipment))

        coVerify { customerDao.upsert(senderDbTestData()) }
        coVerify { customerDao.upsert(receiverDbTestData()) }
        coVerify { shipmentDao.upsert(shipmentDb) }
        coVerify { eventLogDao.upsertAll(eventLogDbTestData()) }
    }
}