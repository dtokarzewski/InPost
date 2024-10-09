package pl.inpost.data.network.model.testdata

import pl.inpost.data.network.model.CustomerNetwork

fun receiverNetworkTestData() = CustomerNetwork(
    email = "receiver@example.com",
    phoneNumber = "500500500",
    name = "John Smith"
)

fun senderNetworkTestData() = CustomerNetwork(
    email = "sender@example.com",
    phoneNumber = "500500500",
    name = "IKEA"
)
