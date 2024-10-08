package pl.inpost.shipmentlist.ui

import app.cash.turbine.test
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.inpost.core.test.MainDispatcherRule
import pl.inpost.domain.data.testdata.shipmentTestData
import pl.inpost.domain.usecase.GetShipmentsAsFlowUseCase
import pl.inpost.domain.usecase.HideShipmentUseCase
import pl.inpost.domain.usecase.RefreshShipmentsUseCase
import pl.inpost.shipmentlist.data.mapper.CustomerUiMapper
import pl.inpost.shipmentlist.data.mapper.OperationsUiMapper
import pl.inpost.shipmentlist.data.mapper.ShipmentStatusUiMapper
import pl.inpost.shipmentlist.data.mapper.ShipmentTypeUiMapper
import pl.inpost.shipmentlist.data.mapper.ShipmentUiMapper
import pl.inpost.shipmentlist.data.model.testdata.shipmentUiTestData

@OptIn(ExperimentalCoroutinesApi::class)
class ShipmentListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val shipmentUiMapper = ShipmentUiMapper(
        shipmentTypeUiMapper = ShipmentTypeUiMapper(),
        shipmentStatusUiMapper = ShipmentStatusUiMapper(),
        customerUiMapper = CustomerUiMapper(),
        operationsUiMapper = OperationsUiMapper(),
    )
    private val getShipmentsUseCase = mockk<GetShipmentsAsFlowUseCase>()
    private val hideShipmentUseCase = mockk<HideShipmentUseCase>()
    private val refreshShipmentsUseCase = mockk<RefreshShipmentsUseCase>()
    private lateinit var sut: ShipmentListViewModel

    @Before
    fun setUp() {
        clearAllMocks()

        every { getShipmentsUseCase.invoke() } returns flowOf(listOf(shipmentTestData()))

        sut = ShipmentListViewModel(
            shipmentUiMapper = shipmentUiMapper,
            getShipmentsUseCase = getShipmentsUseCase,
            hideShipmentUseCase = hideShipmentUseCase,
            refreshShipmentsUseCase = refreshShipmentsUseCase,
        )
    }

    @Test
    fun `GIVEN viewModel in initial state WHEN subscribed to uiState THEN Loading state is emitted`() =
        runTest {
            val expected = ShipmentListState.Loading
            assertEquals(expected, sut.uiState.value)
        }

    @Test
    fun `GIVEN viewModel in Loading state WHEN subscribed and loading finished THEN Loaded state is emitted`() =
        runTest {
            sut.uiState.test {
                assertEquals(idleState, awaitItem())
            }

        }

    @Test
    fun `GIVEN viewModel in Loaded state WHEN hideShipment called with success result THEN hideShipmentUseCase is called`() =
        runTest {
            coEvery { hideShipmentUseCase(any()) } returns Unit

            sut.uiState.test {
                assertEquals(idleState, awaitItem())

                sut.hideShipment("123")

                coVerify { hideShipmentUseCase("123") }
                advanceUntilIdle()
            }
        }

    @Test
    fun `GIVEN viewModel in Loaded state WHEN hideShipment called with error result THEN show error`() =
        runTest {
            coEvery { hideShipmentUseCase(any()) } throws generalException

            sut.uiState.test {
                assertEquals(idleState, awaitItem())

                sut.hideShipment("123")

                coVerify { hideShipmentUseCase("123") }
                assertEquals(errorState, awaitItem())
                advanceUntilIdle()
            }
        }

    @Test
    fun `GIVEN viewModel in Loaded state with error WHEN cleanGeneralError called THEN hide error`() =
        runTest {
            coEvery { hideShipmentUseCase(any()) } throws generalException

            sut.hideShipment("123")
            sut.clearGeneralError()

            sut.uiState.test {
                assertEquals(idleState, awaitItem())
            }
        }

    @Test
    fun `GIVEN viewModel in Loaded state WHEN refresh called THEN show refresh progress and hide after success`() =
        runTest {
            coEvery { refreshShipmentsUseCase() } returns Result.success(Unit)

            sut.uiState.test {
                assertEquals(idleState, awaitItem())

                sut.refresh()

                assertEquals(refreshingState, awaitItem())
                assertEquals(idleState, awaitItem())
            }
        }

    @Test
    fun `GIVEN viewModel in Loaded state WHEN refresh called with error result THEN show refresh progress and error after failure`() =
        runTest {
            coEvery { refreshShipmentsUseCase() } returns Result.failure(refreshException)

            sut.uiState.test {
                assertEquals(idleState, awaitItem())

                sut.refresh()

                assertEquals(refreshingState, awaitItem())
                assertEquals(refreshErrorState, awaitItem())
            }
        }

    @Test
    fun `GIVEN viewModel in Loaded state with refresh error WHEN clearRefreshError called THEN hide refresh error`() =
        runTest {
            coEvery { refreshShipmentsUseCase() } returns Result.failure(refreshException)

            sut.refresh()

            sut.uiState.test {
                assertEquals(refreshErrorState, awaitItem())
                sut.clearRefreshError()
                assertEquals(idleState, awaitItem())
            }
        }

    companion object {
        private val generalException = Exception("Something went wrong")
        private val refreshException = Exception("Failed to refresh")

        private val idleState = ShipmentListState.Loaded(
            shipments = listOf(shipmentUiTestData()),
            refreshState = RefreshState.Idle,
            error = null,
        )
        private val errorState = ShipmentListState.Loaded(
            shipments = listOf(shipmentUiTestData()),
            refreshState = RefreshState.Idle,
            error = generalException,
        )
        private val refreshingState = idleState.copy(
            refreshState = RefreshState.Refreshing,
        )
        private val refreshErrorState = idleState.copy(
            refreshState = RefreshState.Error(refreshException),
        )
    }
}