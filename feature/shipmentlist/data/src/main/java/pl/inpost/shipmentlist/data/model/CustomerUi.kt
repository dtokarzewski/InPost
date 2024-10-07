package pl.inpost.shipmentlist.data.model

data class CustomerUi(
    val email: String?,
    val phoneNumber: String?,
    val name: String?,
    val displayType: CustomerDisplayTypeUi,
)

enum class CustomerDisplayTypeUi {
    EMAIL,
    PHONE_NUMBER,
    NAME,
    NONE,
}