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
import pl.inpost.data.model.Shipment
import pl.inpost.data.model.testdata.shipmentTestData
import pl.inpost.designsystem.InPostTheme
import pl.inpost.shipmentlist.R

@Composable
internal fun ShipmentCard(
    shipment: Shipment,
    onMoreClicked: () -> Unit,
    onHideClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        onClick = onMoreClicked,
        shape = RectangleShape,
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier.wrapContentSize(),
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
            // TODO HARDCODE move date and label resolution to mapper or domain
            ShipmentStatus(
                status = stringResource(R.string.status_ready_to_pickup),
                dateLabel = stringResource(R.string.label_awaiting),
                date = shipment.expiryDate?.toString(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            // TODO HARDCODE move sender resolution to mapper or domain
            Sender(
                sender = shipment.sender?.email ?: "",
            )
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
    status: String,
    dateLabel: String,
    date: String?,
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
                text = stringResource(R.string.label_parcel_status).uppercase(),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = status,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        if (date != null) {
            Column(
                modifier = Modifier.weight(2f),
            ) {
                Text(
                    text = dateLabel.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun Sender(
    sender: String,
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
            Text(
                text = stringResource(R.string.label_sender).uppercase(),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = sender,
                style = MaterialTheme.typography.bodyMedium,
            )
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
                shipment = shipmentTestData(),
                onMoreClicked = {},
                onHideClicked = {},
            )
        }
    }
}

