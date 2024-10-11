package pl.inpost.shipmentlist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
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
        ShipmentListState.Loading -> {
            ProgressIndicator()
        }

        is ShipmentListState.Loaded -> ShipmentScreen(
            uiState = state,
            onRefresh = viewModel::refresh,
            onMoreClicked = { /* TODO Implement details screen */ },
            onHideShipment = viewModel::hideShipment,
            onGeneralErrorShown = viewModel::clearGeneralError,
            onRefreshErrorShown = viewModel::clearRefreshError,
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
    onGeneralErrorShown: () -> Unit,
    onRefreshErrorShown: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                modifier = Modifier,
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        val shipments = uiState.shipments

        /* We assume that highlighted items are on top on the list - sorting on DB site is faster
        *  than filtering here. */
        val lastHighlightedIndex =
            shipments.indexOfLast { shipment -> shipment.operations.highlight }
        val highlightedShipment =
            if (lastHighlightedIndex != -1) shipments.subList(0, lastHighlightedIndex + 1) else null
        val otherShipments = shipments.subList(lastHighlightedIndex + 1, shipments.size)

        PullToRefreshBox(
            isRefreshing = uiState.refreshState == RefreshState.Refreshing,
            onRefresh = onRefresh,
            modifier = Modifier.padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier
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

            val (errorMessage: String?, onErrorShown: (() -> Unit)?) = when {
                uiState.error != null -> stringResource(R.string.error_general) to onGeneralErrorShown
                uiState.refreshState is RefreshState.Error -> stringResource(R.string.error_refresh_failed) to onRefreshErrorShown
                else -> null to null
            }

            errorMessage?.let {
                LaunchedEffect(errorMessage) {
                    snackbarHostState.showSnackbar(
                        message = errorMessage
                    )
                    onErrorShown?.invoke()
                }
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

@Composable
fun ProgressIndicator() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
    ) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(80.dp)
                    .clipToBounds()
                    .align(Center)
            )
        }
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
            onGeneralErrorShown = {},
            onRefreshErrorShown = {},
        )
    }
}

@Preview
@Composable
private fun ProgressIndicatorPreview() {
    InPostTheme {
        ProgressIndicator()
    }
}