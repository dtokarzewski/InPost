package pl.inpost.domain.usecase

import app.cash.turbine.test
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.data.testdata.shipmentTestData
import pl.inpost.domain.repository.ShipmentRepository
import java.io.IOException

class GetShipmentsAsFlowUseCaseTest {
    private lateinit var sut: GetShipmentsAsFlowUseCase
    private val shipmentRepository = mockk<ShipmentRepository>()

    @Before
    fun setUp() {
        sut = GetShipmentsAsFlowUseCase(shipmentRepository)
    }

    @Test
    fun `GIVEN useCase WHEN invoke with success result THEN return flow of shipments`() = runTest {
        every { shipmentRepository.getShipmentsAsFlow() } returns flowOf(listOf(shipmentTestData()))

        val expected = listOf(shipmentTestData())

        sut.invoke().test {
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test(expected = IOException::class)
    fun `GIVEN useCase WHEN invoke with error result THEN throw exception`() = runTest {
        every { shipmentRepository.getShipmentsAsFlow() } throws IOException()

        val expected = listOf(shipmentTestData())

        sut.invoke().test {
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }
}
