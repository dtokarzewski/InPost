package pl.inpost.data.network.model.testdata

import pl.inpost.data.network.model.EventLogDto
import pl.inpost.data.network.model.OperationsDto
import pl.inpost.data.network.model.ShipmentDto
import pl.inpost.data.network.model.testdata.receiverDtoTestData
import pl.inpost.data.network.model.testdata.senderDtoTestData
import java.time.ZonedDateTime

fun shipmentDtoTestData() = ShipmentDto(
    number = "16730345345597442248333",
    shipmentType = "PARCEL_LOCKER",
    status = "READY_TO_PICKUP",
    eventLog = listOf(
        EventLogDto(
            name = "READY_TO_PICKUP",
            date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
        ),
        EventLogDto(
            name = "SENT_FROM_SOURCE_BRANCH",
            date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
        ),
        EventLogDto(
            name = "CONFIRMED",
            date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
        ),
    ),
    openCode = "987654",
    expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
    storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
    pickUpDate = null,
    receiver = receiverDtoTestData(),
    sender = senderDtoTestData(),
    operations = OperationsDto(
        delete = true,
        manualArchive = true,
        collect = true,
        highlight = true,
        expandAvizo = true,
        endOfWeekCollection = false,
    ),
)