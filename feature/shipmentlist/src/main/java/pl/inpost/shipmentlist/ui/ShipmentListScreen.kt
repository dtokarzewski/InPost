package pl.inpost.shipmentlist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.inpost.designsystem.InPostTheme
import pl.inpost.designsystem.LightGray
import pl.inpost.shipmentlist.R
import pl.inpost.shipmentlist.data.model.testdata.shipmentsUiTestData
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
    ) { it ->
        val shipments = uiState.shipments

        /* We assume that highlighted items are on top on the list - sorting on DB site is faster
        *  than filtering here. */
        val lastHighlightedIndex =
            shipments.indexOfLast { shipment -> shipment.operations.highlight }
        val highlightedShipment =
            if (lastHighlightedIndex != -1) shipments.subList(0, lastHighlightedIndex + 1) else null
        val otherShipments = shipments.subList(lastHighlightedIndex + 1, shipments.size)

        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            highlightedShipment?.let { highlighted ->
                item {
                    Divider(
                        title = stringResource(R.string.menu_ready_to_pickup),
                        modifier = Modifier.padding(
                            top = 16.dp,
                        )
                    )
                }
                items(
                    count = highlighted.size,
                    key = { index -> highlighted[index].number },
                ) { index ->
                    val shipment = highlighted[index]
                    ShipmentCard(
                        shipment = shipment,
                        onMoreClicked = onMoreClicked,
                        onHideClicked = onHideShipment,
                    )
                }
                if (otherShipments.isNotEmpty()) {
                    item {
                        Divider(
                            title = stringResource(R.string.menu_other),
                        )
                    }
                }
            }

            items(
                count = otherShipments.size,
                key = { index -> otherShipments[index].number },
            ) { index ->
                val shipment = otherShipments[index]
                ShipmentCard(
                    shipment = shipment,
                    onMoreClicked = onMoreClicked,
                    onHideClicked = onHideShipment,
                )
            }
        }
    }
}

@Composable
internal fun Divider(
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Center,
        modifier = modifier
            .padding(vertical = 8.dp),
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = LightGray
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            modifier = Modifier
                .wrapContentSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview
@Composable
private fun DividerPreview() {
    InPostTheme {
        Divider(
            title = stringResource(R.string.menu_ready_to_pickup),
        )
    }
}

@Preview
@Composable
private fun ShipmentScreenPreview() {
    InPostTheme {
        ShipmentScreen(
            uiState = ShipmentListState.Loaded(
                shipments = shipmentsUiTestData(),
                refreshState = RefreshState.Idle,
                error = null,
            ),
            onRefresh = {},
            onMoreClicked = {},
            onHideShipment = {},
        )
    }
}