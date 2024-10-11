package pl.inpost.shipmentlist.ui

import pl.inpost.shipmentlist.data.model.ShipmentUi

sealed class ShipmentListState {
    data object Loading : ShipmentListState()

    data class Loaded(
        val shipments: List<ShipmentUi>,
        val refreshState: RefreshState,
        val error: Throwable? = null,
    ) : ShipmentListState()
}

sealed class RefreshState {
    data object Idle : RefreshState()
    data object Refreshing : RefreshState()
    data class Error(val error: Throwable) : RefreshState()
}
