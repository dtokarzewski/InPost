package pl.inpost.network.model.testdata

import pl.inpost.network.model.CustomerDto

fun receiverDtoTestData() = CustomerDto(
    email = "receiver@example.com",
    phoneNumber = "500500500",
    name = "John Smith"
)

fun senderDtoTestData() = CustomerDto(
    email = "sender@example.com",
    phoneNumber = "500500500",
    name = "IKEA"
)