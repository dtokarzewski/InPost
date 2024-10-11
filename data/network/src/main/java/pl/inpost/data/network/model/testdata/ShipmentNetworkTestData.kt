package pl.inpost.data.network.model.testdata

import pl.inpost.data.network.model.EventLogNetwork
import pl.inpost.data.network.model.ShipmentNetwork
import pl.inpost.data.network.model.ShipmentStatusNetwork
import pl.inpost.data.network.model.ShipmentTypeNetwork
import java.time.ZonedDateTime

fun shipmentsNetworkTestData(): List<ShipmentNetwork> = listOf(
    ShipmentNetwork(
        number = "16730345345597442248333",
        shipmentType = ShipmentTypeNetwork.PARCEL_LOCKER,
        status = ShipmentStatusNetwork.READY_TO_PICKUP,
        eventLog = listOf(
            EventLogNetwork(
                name = "READY_TO_PICKUP",
                date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
            ),
            EventLogNetwork(
                name = "SENT_FROM_SOURCE_BRANCH",
                date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
            ),
            EventLogNetwork(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverNetworkTestData(),
        sender = senderNetworkTestData(),
        operations = operationsNetworkTestData(),
    ),
    ShipmentNetwork(
        number = "26730345345597442248333",
        shipmentType = ShipmentTypeNetwork.PARCEL_LOCKER,
        status = ShipmentStatusNetwork.CONFIRMED,
        eventLog = listOf(
            EventLogNetwork(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverNetworkTestData(),
        sender = senderNetworkTestData().copy(name = "Offy"),
        operations = operationsNetworkTestData().copy(
            highlight = false,
        ),
    ),
    ShipmentNetwork(
        number = "36730345345597442248333",
        shipmentType = ShipmentTypeNetwork.PARCEL_LOCKER,
        status = ShipmentStatusNetwork.READY_TO_PICKUP,
        eventLog = listOf(
            EventLogNetwork(
                name = "READY_TO_PICKUP",
                date = ZonedDateTime.parse("2018-08-01T04:56:07Z")
            ),
            EventLogNetwork(
                name = "SENT_FROM_SOURCE_BRANCH",
                date = ZonedDateTime.parse("2018-08-18T04:56:07Z")
            ),
            EventLogNetwork(
                name = "CONFIRMED",
                date = ZonedDateTime.parse("2018-08-14T04:56:07Z")
            ),
        ),
        openCode = "987654",
        expiryDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        storedDate = ZonedDateTime.parse("2022-11-27T04:56:07Z"),
        pickUpDate = null,
        receiver = receiverNetworkTestData(),
        sender = senderNetworkTestData(),
        operations = operationsNetworkTestData(),
    )
)

fun shipmentNetworkTestData(): ShipmentNetwork = shipmentsNetworkTestData().first()
