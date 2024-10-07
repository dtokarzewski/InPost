package pl.inpost.shipmentlist.data.mapper

import pl.inpost.domain.data.Customer
import pl.inpost.shipmentlist.data.model.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.model.CustomerUi
import timber.log.Timber
import javax.inject.Inject

class CustomerUiMapper @Inject constructor() {
    fun toUi(customer: Customer): CustomerUi {
        val displayType = when {
            !customer.name.isNullOrBlank() -> CustomerDisplayTypeUi.NAME
            !customer.email.isNullOrBlank() -> CustomerDisplayTypeUi.EMAIL
            !customer.phoneNumber.isNullOrBlank() -> CustomerDisplayTypeUi.PHONE_NUMBER
            else -> {
                Timber.e("Customer is empty: $customer")
                CustomerDisplayTypeUi.NONE
            }
        }
        return with(customer) {
            CustomerUi(
                email = email,
                phoneNumber = phoneNumber,
                name = name,
                displayType = displayType,
            )
        }
    }
}
