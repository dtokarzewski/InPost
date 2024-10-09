package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.CustomerNetwork
import pl.inpost.domain.data.Customer
import javax.inject.Inject

class CustomerNetworkMapper @Inject constructor() {
    fun toDomain(customer: CustomerNetwork) = Customer(
        email = customer.email,
        phoneNumber = customer.phoneNumber,
        name = customer.name
    )
}
