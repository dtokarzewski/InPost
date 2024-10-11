package pl.inpost.domain.data.testdata

import pl.inpost.domain.data.Shipment
import pl.inpost.domain.data.EventLog
import pl.inpost.domain.data.ShipmentStatus
import pl.inpost.domain.data.ShipmentType
import java.time.ZonedDateTime

fun shipmentsTestData(): List<Shipment> = listOf(
    Shipment(
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
        isHidden = false,
        operations = operationsTestData(),
    ),
    Shipment(
        number = "26730345345597442248333",
        shipmentType = ShipmentType.PARCEL_LOCKER,
        status = ShipmentStatus.CONFIRMED,
        eventLog = listOf(
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
        sender = senderTestData().copy(name = "Offy"),
        isHidden = false,
        operations = operationsTestData().copy(
            highlight = false,
        ),
    ),
    Shipment(
        number = "36730345345597442248333",
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
        expiryDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverTestData(),
        sender = senderTestData(),
        isHidden = false,
        operations = operationsTestData(),
    )
)

fun shipmentTestData(): Shipment = shipmentsTestData().first()
