package pl.inpost.domain.data.testdata

import pl.inpost.domain.data.Customer

fun receiverTestData() = Customer(
    email = "receiver@example.com",
    phoneNumber = "500500500",
    name = "John Smith"
)

fun senderTestData() = Customer(
    email = "sender@example.com",
    phoneNumber = "500500500",
    name = "IKEA"
)