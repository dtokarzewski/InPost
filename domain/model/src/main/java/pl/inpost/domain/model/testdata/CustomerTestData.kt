package pl.inpost.domain.model.testdata

import pl.inpost.domain.model.Customer

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