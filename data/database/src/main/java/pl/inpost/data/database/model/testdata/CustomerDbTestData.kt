package pl.inpost.data.database.model.testdata

import pl.inpost.data.database.model.CustomerDb

fun receiverDbTestData() = CustomerDb(
    email = "receiver@example.com",
    phoneNumber = "500500500",
    name = "John Smith"
)

fun senderDbTestData() = CustomerDb(
    email = "sender@example.com",
    phoneNumber = "500500500",
    name = "IKEA"
)
