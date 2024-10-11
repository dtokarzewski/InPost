package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.CustomerDb
import pl.inpost.domain.data.Customer
import javax.inject.Inject

class CustomerDbMapper @Inject constructor() {
    fun toDomain(customer: CustomerDb) = Customer(
        email = customer.email,
        phoneNumber = customer.phoneNumber,
        name = customer.name
    )

    fun toEntity(customer: Customer) = CustomerDb(
        email = customer.email,
        phoneNumber = customer.phoneNumber,
        name = customer.name
    )
}
