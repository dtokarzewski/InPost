package pl.inpost.shipmentlist.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pl.inpost.shipmentlist.data.model.testdata.shipmentUiTestData

class ShipmentCardKtTest {

    @Composable
    @Preview
    fun ShipmentCardPreview() {
        ShipmentCard(
            shipment = shipmentUiTestData(),
            onMoreClicked = {},
            onHideClicked = {},
        )
    }
}
