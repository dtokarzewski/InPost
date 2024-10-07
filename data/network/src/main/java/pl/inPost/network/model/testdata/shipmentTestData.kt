package pl.inpost.data.model.testdata

import pl.inpost.data.model.Customer
import pl.inpost.data.model.EventLog
import pl.inpost.data.model.Operations
import pl.inpost.data.model.Shipment
import java.time.ZonedDateTime

fun shipmentTestData() = Shipment(
    number = "16730345345597442248333",
    shipmentType = "PARCEL_LOCKER",
    status = "READY_TO_PICKUP",
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
    receiver = Customer(
        email = "receiver@example.com",
        phoneNumber = "500500500",
        name = "John Smith"
    ),
    sender = Customer(
        email = "sender@example.com",
        phoneNumber = "500500500",
        name = "IKEA",
    ),
    operations = Operations(
        delete = true,
        manualArchive = true,
        collect = true,
        highlight = true,
        expandAvizo = true,
        endOfWeekCollection = false,
    ),
)