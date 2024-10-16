package pl.inpost.data.database.testdata

import pl.inpost.data.database.model.PopulatedShipmentDb

fun populatedShipmentDbTestData() = PopulatedShipmentDb(
    shipment = shipmentDbTestData(),
    eventLog = eventLogDbTestData(),
    receiver = receiverDbTestData(),
    sender = senderDbTestData(),
)