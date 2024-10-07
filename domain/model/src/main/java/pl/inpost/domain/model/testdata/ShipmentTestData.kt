package pl.inpost.domain.model.testdata

import pl.inpost.domain.model.Shipment
import pl.inpost.domain.model.Customer
import pl.inpost.domain.model.Operations
import pl.inpost.domain.model.EventLog
import pl.inpost.domain.model.ShipmentStatus
import pl.inpost.domain.model.ShipmentType
import java.time.ZonedDateTime

fun shipmentTestData(): Shipment = Shipment(
    number = "16730345345597442248333",
    shipmentType = ShipmentType.PARCEL_LOCKER,
    status = ShipmentStatus.READY_TO_PICKUP,
    eventLog = listOf(
        EventLog(
            name = "READY_TO_PICKUP",
            date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
        ),
        EventLog(
            name = "SENT_FROM_SOURCE_BRANCH",
            date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
        ),
        EventLog(
            name = "CONFIRMED",
            date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
        ),
    ),
    openCode = "987654",
    expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
    storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
    pickUpDate = null,
    receiver = receiverTestData(),
    sender = senderTestData(),
    operations = operationsTestData(),
)