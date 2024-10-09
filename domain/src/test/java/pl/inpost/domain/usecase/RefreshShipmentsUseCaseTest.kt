package pl.inpost.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.repository.ShipmentRepository
import java.io.IOException

class RefreshShipmentsUseCaseTest {
    private lateinit var sut: RefreshShipmentsUseCase
    private val shipmentRepository = mockk<ShipmentRepository>()

    @Before
    fun setUp() {
        sut = RefreshShipmentsUseCase(shipmentRepository)
    }

    @Test
    fun `GIVEN useCase WHEN invoke with success result THEN return success result`() = runTest {
        coEvery { shipmentRepository.refreshShipments() } returns Result.success(Unit)
        val expected = Result.success(Unit)

        val result = sut.invoke()

        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN useCase WHEN invoke with error result THEN return failure result`() = runTest {
        val exception = IOException("Failed to refresh")
        coEvery { shipmentRepository.refreshShipments() } returns Result.failure(exception)
        val expected = Result.failure<Unit>(exception)

        val result = sut.invoke()

        assertEquals(expected, result)
    }
}
