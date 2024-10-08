package pl.inpost.shipmentlist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import pl.inpost.designsystem.InPostTheme
import pl.inpost.shipmentlist.R
import pl.inpost.shipmentlist.data.model.testdata.shipmentUiTestData
import pl.inpost.shipmentlist.ui.component.ShipmentCard

@Composable
fun ShipmentScreen(
    viewModel: ShipmentListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        ShipmentListState.Loading -> { /*TODO Implement full screen progress indicator */
        }

        is ShipmentListState.Loaded -> ShipmentScreen(
            uiState = state,
            onRefresh = viewModel::refresh,
            onMoreClicked = { /* TODO Implement details screen */ },
            onHideShipment = viewModel::hideShipment,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ShipmentScreen(
    uiState: ShipmentListState.Loaded,
    onRefresh: () -> Unit,
    onMoreClicked: (String) -> Unit,
    onHideShipment: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                modifier = Modifier,
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
        ) {
            items(
                count = uiState.shipments.size,
                key = { index -> uiState.shipments[index].number },
            ) { index ->
                val shipment = uiState.shipments[index]

                ShipmentCard(
                    shipment = shipment,
                    onMoreClicked = onMoreClicked,
                    onHideClicked = onHideShipment,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShipmentScreenPreview() {
    InPostTheme {
        ShipmentScreen(
            uiState = ShipmentListState.Loaded(
                shipments = listOf(shipmentUiTestData()),
                refreshState = RefreshState.Idle,
                error = null,
            ),
            onRefresh = {},
            onMoreClicked = {},
            onHideShipment = {},
        )
    }
}