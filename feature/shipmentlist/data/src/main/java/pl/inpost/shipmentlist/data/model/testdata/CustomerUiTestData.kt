package pl.inpost.shipmentlist.data.model.testdata

import pl.inpost.shipmentlist.data.model.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.model.CustomerUi

fun senderUiTestData() = CustomerUi(
    email = "sender@example.com",
    phoneNumber = "500500500",
    name = "IKEA",
    displayType = CustomerDisplayTypeUi.NAME,
)

fun receiverUiTestData() = CustomerUi(
    email = "receiver@example.com",
    phoneNumber = "500500500",
    name = "John Smith",
    displayType = CustomerDisplayTypeUi.NAME,
)