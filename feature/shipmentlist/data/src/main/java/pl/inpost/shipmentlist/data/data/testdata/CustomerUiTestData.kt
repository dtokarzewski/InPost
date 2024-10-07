package pl.inpost.shipmentlist.data.data.testdata

import pl.inpost.shipmentlist.data.data.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.data.CustomerUi

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