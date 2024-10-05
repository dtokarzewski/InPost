package pl.dtokarzewski.data.testdata

import pl.dtokarzewski.data.OperationsUi
import pl.dtokarzewski.data.ShipmentStatusUi
import pl.dtokarzewski.data.ShipmentTypeUi
import pl.dtokarzewski.data.ShipmentUi

fun shipmentTestData() = ShipmentUi(
    number = "16730345345597442248333",
    shipmentType = ShipmentTypeUi.PARCEL_LOCKER,
    status = ShipmentStatusUi.READY_TO_PICKUP,
    statusDate = "tue. | 29.11.22 | 04:56",
    receiver = "IKEA",
    sender = "sender",
    operations = OperationsUi(
        delete = true,
        manualArchive = true,
        collect = true,
        highlight = true,
        expandAvizo = true,
        endOfWeekCollection = false,
    ),
)
