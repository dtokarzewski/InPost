package pl.inpost.data.database.model.testdata

import pl.inpost.data.database.model.ShipmentDb
import pl.inpost.data.database.model.ShipmentStatusDb
import pl.inpost.data.database.model.ShipmentTypeDb
import java.time.ZonedDateTime

fun shipmentsDbTestData(): List<ShipmentDb> = listOf(
    ShipmentDb(
        shipmentNumber = "16730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.READY_TO_PICKUP,
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiverId = 1,
        senderId = 2,
        isHidden = false,
        operations = operationsDbTestData(),
    ),
    ShipmentDb(
        shipmentNumber = "26730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.CONFIRMED,
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiverId = 1,
        senderId = 2,
        isHidden = false,
        operations = operationsDbTestData().copy(
            highlight = false,
        ),
    ),
    ShipmentDb(
        shipmentNumber = "36730345345597442248333",
        shipmentType = ShipmentTypeDb.PARCEL_LOCKER,
        status = ShipmentStatusDb.READY_TO_PICKUP,
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        pickUpDate = null,
        receiverId = 1,
        senderId = 2,
        isHidden = false,
        operations = operationsDbTestData(),
    )
)

fun shipmentDbTestData(): ShipmentDb = shipmentsDbTestData().first()
