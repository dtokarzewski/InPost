package pl.inpost.domain.usecase

import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.repository.ShipmentRepository
import java.io.IOException

class HideShipmentUseCaseTest {
    private lateinit var sut: HideShipmentUseCase

    private val shipmentRepository = mockk<ShipmentRepository>()

    @Before
    fun setUp() {
        sut = HideShipmentUseCase(shipmentRepository)
    }

    @Test
    fun `GIVEN useCase WHEN invoke with success result THEN finish successfully`() = runTest {
        coJustRun { shipmentRepository.hideShipment(any()) }

        sut.invoke("123")

        coVerify(exactly = 1) { shipmentRepository.hideShipment("123") }
    }

    @Test(expected = IOException::class)
    fun `GIVEN useCase WHEN invoke with error result THEN throw exception`() = runTest {
        coEvery { shipmentRepository.hideShipment(any()) } throws IOException()

        sut.invoke("123")
    }
}