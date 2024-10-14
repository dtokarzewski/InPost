package pl.inpost.shipmentlist.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pl.inpost.designsystem.InPostTheme
import pl.inpost.shipmentlist.data.model.testdata.shipmentsUiTestData
import java.io.IOException

class ShipmentListScreenTest {

    @Preview
    @Composable
    fun ShipmentListScreenPreview() {
        InPostTheme {
            ShipmentListScreen(
                uiState = ShipmentListState.Loaded(
                    shipments = shipmentsUiTestData(),
                    refreshState = RefreshState.Idle,
                    error = null,
                ),
                onRefresh = {},
                onMoreClicked = {},
                onHideShipment = {},
                onGeneralErrorShown = {},
                onRefreshErrorShown = {},
            )
        }
    }

    @Preview
    @Composable
    fun ShipmentListScreenEmptyListPreview() {
        InPostTheme {
            ShipmentListScreen(
                uiState = ShipmentListState.Loaded(
                    shipments = emptyList(),
                    refreshState = RefreshState.Idle,
                    error = null,
                ),
                onRefresh = {},
                onMoreClicked = {},
                onHideShipment = {},
                onGeneralErrorShown = {},
                onRefreshErrorShown = {},
            )
        }
    }

    @Preview
    @Composable
    fun ShipmentListScreenRefreshingPreview() {
        InPostTheme {
            ShipmentListScreen(
                uiState = ShipmentListState.Loaded(
                    shipments = shipmentsUiTestData(),
                    refreshState = RefreshState.Refreshing,
                    error = null,
                ),
                onRefresh = {},
                onMoreClicked = {},
                onHideShipment = {},
                onGeneralErrorShown = {},
                onRefreshErrorShown = {},
            )
        }
    }

    @Preview
    @Composable
    fun ShipmentListScreenRefreshErrorPreview() {
        InPostTheme {
            ShipmentListScreen(
                uiState = ShipmentListState.Loaded(
                    shipments = shipmentsUiTestData(),
                    refreshState = RefreshState.Error(
                        error = IOException("Test")
                    ),
                    error = null,
                ),
                onRefresh = {},
                onMoreClicked = {},
                onHideShipment = {},
                onGeneralErrorShown = {},
                onRefreshErrorShown = {},
            )
        }
    }
}