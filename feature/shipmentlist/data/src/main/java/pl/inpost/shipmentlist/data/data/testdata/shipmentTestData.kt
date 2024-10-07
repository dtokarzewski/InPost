package pl.inpost.shipmentlist.data.data.testdata

import pl.inpost.shipmentlist.data.data.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.data.CustomerUi
import pl.inpost.shipmentlist.data.data.OperationsUi
import pl.inpost.shipmentlist.data.data.ShipmentDisplayDateTypeUi
import pl.inpost.shipmentlist.data.data.ShipmentStatusUi
import pl.inpost.shipmentlist.data.data.ShipmentTypeUi
import pl.inpost.shipmentlist.data.data.ShipmentUi

fun shipmentTestData() = ShipmentUi(
    number = "16730345345597442248333",
    shipmentType = ShipmentTypeUi.PARCEL_LOCKER,
    status = ShipmentStatusUi.READY_TO_PICKUP,
    expiryDate = "tue. | 29.11.22 | 04:56",
    storedDate = "tue. | 29.11.22 | 04:56",
    pickUpDate = null,
    dateDisplayType = ShipmentDisplayDateTypeUi.EXPIRY_DATE,
    receiver = CustomerUi(
        email = "receiver@example.com",
        phoneNumber = "500500500",
        name = "John Smith",
        displayType = CustomerDisplayTypeUi.NAME,
    ),
    sender = CustomerUi(
        email = "sender@example.com",
        phoneNumber = "500500500",
        name = "IKEA",
        displayType = CustomerDisplayTypeUi.NAME,
    ),
    operations = OperationsUi(
        delete = true,
        manualArchive = true,
        collect = true,
        highlight = true,
        expandAvizo = true,
        endOfWeekCollection = false,
    ),
)
