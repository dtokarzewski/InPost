package pl.inpost.shipmentlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.inpost.domain.usecase.GetShipmentsAsFlowUseCase
import pl.inpost.domain.usecase.HideShipmentUseCase
import pl.inpost.domain.usecase.RefreshShipmentsUseCase
import pl.inpost.shipmentlist.data.mapper.ShipmentUiMapper
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ShipmentListViewModel @Inject constructor(
    getShipmentsUseCase: GetShipmentsAsFlowUseCase,
    private val shipmentUiMapper: ShipmentUiMapper,
    private val hideShipmentUseCase: HideShipmentUseCase,
    private val refreshShipmentsUseCase: RefreshShipmentsUseCase,
) : ViewModel() {

    private val refreshState = MutableStateFlow<RefreshState>(RefreshState.Idle)
    private val error = MutableStateFlow<Throwable?>(null)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        error.value = throwable
    }

    val uiState: StateFlow<ShipmentListState> = combine(
        refreshState,
        error,
        getShipmentsUseCase(),
    ) { refresh, error, shipments ->
        ShipmentListState.Loaded(
            shipments = shipments.map { shipmentUiMapper.toUi(it) },
            refreshState = refresh,
            error = error
        )
    }.onStart {
        refresh()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ShipmentListState.Loading,
    )

    fun hideShipment(shipmentNumber: String) {
        viewModelScope.launch(exceptionHandler) {
            coroutineContext
            hideShipmentUseCase(shipmentNumber)
        }
    }

    fun refresh() {
        refreshState.value = RefreshState.Refreshing
        viewModelScope.launch {
            runCatching {
                refreshShipmentsUseCase()
            }.onSuccess {
                refreshState.value = RefreshState.Idle
            }.onFailure {
                Timber.e(it)
                refreshState.value = RefreshState.Error(it)
            }
        }
    }

    fun clearGeneralError() {
        error.value = null
    }

    fun clearRefreshError() {
        refreshState.value = RefreshState.Idle
    }
}