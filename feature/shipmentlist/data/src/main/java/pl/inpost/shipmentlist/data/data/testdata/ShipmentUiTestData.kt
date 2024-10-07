package pl.inpost.shipmentlist.data.data.testdata

import pl.inpost.shipmentlist.data.data.ShipmentDisplayDateTypeUi
import pl.inpost.shipmentlist.data.data.ShipmentStatusUi
import pl.inpost.shipmentlist.data.data.ShipmentTypeUi
import pl.inpost.shipmentlist.data.data.ShipmentUi

fun shipmentUiTestData() = ShipmentUi(
    number = "16730345345597442248333",
    shipmentType = ShipmentTypeUi.PARCEL_LOCKER,
    status = ShipmentStatusUi.READY_TO_PICKUP,
    expiryDate = "tue. | 29.11.22 | 04:56",
    storedDate = "tue. | 29.11.22 | 04:56",
    pickUpDate = null,
    dateDisplayType = ShipmentDisplayDateTypeUi.EXPIRY_DATE,
    receiver = receiverUiTestData(),
    sender = senderUiTestData(),
    operations = operationsUiTestData(),
)
