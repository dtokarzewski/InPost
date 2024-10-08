package pl.inpost.shipmentlist.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.inpost.designsystem.InPostTheme
import pl.inpost.shipmentlist.R
import pl.inpost.shipmentlist.data.model.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.model.CustomerUi
import pl.inpost.shipmentlist.data.model.ShipmentDisplayDateTypeUi
import pl.inpost.shipmentlist.data.model.ShipmentStatusUi
import pl.inpost.shipmentlist.data.model.ShipmentUi
import pl.inpost.shipmentlist.data.model.testdata.shipmentUiTestData

@Composable
internal fun ShipmentCard(
    shipment: ShipmentUi,
    onMoreClicked: (String) -> Unit,
    onHideClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        onClick = { onMoreClicked(shipment.number) },
        shape = RectangleShape,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        ),
        modifier = modifier
            .wrapContentSize()
            .padding(vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 16.dp,
            )
        ) {
            ShipmentNumber(
                number = shipment.number,
            )
            Spacer(modifier = Modifier.height(16.dp))
            ShipmentStatus(
                shipment = shipment,
            )
            Spacer(modifier = Modifier.height(16.dp))
            shipment.sender?.let {
                Sender(
                    sender = it,
                )
            }
        }
    }
}

@Composable
internal fun ShipmentNumber(
    number: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = stringResource(R.string.label_parcel_number).uppercase(),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = number,
                style = MaterialTheme.typography.bodySmall,
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_parcel_locker),
            contentDescription = null,
        )
    }
}

@Composable
internal fun ShipmentStatus(
    shipment: ShipmentUi,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.weight(0.4f),
        ) {
            Text(
                text = stringResource(R.string.label_parcel_status).uppercase(),
                style = MaterialTheme.typography.labelMedium,
            )
            val statusTextId = when (shipment.status) {
                ShipmentStatusUi.ADOPTED_AT_SORTING_CENTER -> R.string.status_adopted_at_sorting_center
                ShipmentStatusUi.SENT_FROM_SORTING_CENTER -> R.string.status_sent_from_sorting_center
                ShipmentStatusUi.ADOPTED_AT_SOURCE_BRANCH -> R.string.status_adopted_at_source_branch
                ShipmentStatusUi.SENT_FROM_SOURCE_BRANCH -> R.string.status_sent_from_source_branch
                ShipmentStatusUi.AVIZO -> R.string.status_avizo
                ShipmentStatusUi.CONFIRMED -> R.string.status_confirmed
                ShipmentStatusUi.CREATED -> R.string.status_created
                ShipmentStatusUi.DELIVERED -> R.string.status_delivered
                ShipmentStatusUi.OTHER -> R.string.status_other
                ShipmentStatusUi.OUT_FOR_DELIVERY -> R.string.status_out_for_delivery
                ShipmentStatusUi.PICKUP_TIME_EXPIRED -> R.string.status_pickup_time_expired
                ShipmentStatusUi.READY_TO_PICKUP -> R.string.status_ready_to_pickup
                ShipmentStatusUi.RETURNED_TO_SENDER -> R.string.status_returned_to_sender
            }
            Text(
                text = stringResource(statusTextId),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        val (dateLabel, displayDate) = when (shipment.dateDisplayType) {
            ShipmentDisplayDateTypeUi.PICKUP_DATE -> Pair(
                stringResource(R.string.label_delivered),
                shipment.pickUpDate
            )

            ShipmentDisplayDateTypeUi.EXPIRY_DATE -> Pair(
                stringResource(
                    if (shipment.status == ShipmentStatusUi.PICKUP_TIME_EXPIRED) {
                        R.string.label_expired
                    } else {
                        R.string.label_awaiting
                    }
                ),
                shipment.expiryDate
            )

            ShipmentDisplayDateTypeUi.STORED_DATE -> Pair(
                stringResource(R.string.label_stored),
                shipment.storedDate
            )

            ShipmentDisplayDateTypeUi.NONE -> Pair(null, null)
        }
        if (dateLabel != null && displayDate != null) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(0.6f),
            ) {
                Text(
                    text = dateLabel.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    text = displayDate,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun Sender(
    sender: CustomerUi,
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            val senderText = when (sender.displayType) {
                CustomerDisplayTypeUi.NAME -> sender.name
                CustomerDisplayTypeUi.EMAIL -> sender.email
                CustomerDisplayTypeUi.PHONE_NUMBER -> sender.phoneNumber
                CustomerDisplayTypeUi.NONE -> null
            }
            senderText?.let {
                Text(
                    text = stringResource(R.string.label_sender).uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
        Text(
            text = stringResource(R.string.label_more).lowercase(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(end = 4.dp),
        )
        Image(
            painter = painterResource(R.drawable.ic_arrow),
            contentDescription = null,
        )
    }
}

@Preview("Shipment Card")
@Composable
private fun ShipmentCardPreview() {
    InPostTheme {
        Surface {
            ShipmentCard(
                shipment = shipmentUiTestData(),
                onMoreClicked = {},
                onHideClicked = {},
            )
        }
    }
}

