package pl.inpost.data.database.model.testdata

import pl.inpost.data.network.model.EventLogDb
import pl.inpost.data.database.model.ShipmentDb
import pl.inpost.data.database.model.ShipmentStatusDb
import pl.inpost.data.database.model.ShipmentTypeDb
import java.time.ZonedDateTime

fun shipmentsDbTestData(): List<ShipmentDb> = listOf(
    ShipmentDb(
        number = "16730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.READY_TO_PICKUP,
        eventLog = listOf(
            EventLogDb(
                name = "READY_TO_PICKUP",
                date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
            ),
            EventLogDb(
                name = "SENT_FROM_SOURCE_BRANCH",
                date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
            ),
            EventLogDb(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverDbTestData(),
        sender = senderDbTestData().copy(name = "x-kom.pl"),
        operations = operationsDbTestData(),
    ),
    ShipmentDb(
        number = "26730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.CONFIRMED,
        eventLog = listOf(
            EventLogDb(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverDbTestData(),
        sender = senderDbTestData().copy(name = "Offy"),
        operations = operationsDbTestData().copy(
            highlight = false,
        ),
    ),
    ShipmentDb(
        number = "36730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.READY_TO_PICKUP,
        eventLog = listOf(
            EventLogDb(
                name = "READY_TO_PICKUP",
                date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
            ),
            EventLogDb(
                name = "SENT_FROM_SOURCE_BRANCH",
                date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
            ),
            EventLogDb(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverDbTestData(),
        sender = senderDbTestData(),
        operations = operationsDbTestData(),
    )
)

fun shipmentDbTestData(): ShipmentDb = shipmentsDbTestData().first()
