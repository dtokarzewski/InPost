package pl.inpost.shipmentlist.data.model

data class ShipmentUi(
    val number: String,
    val shipmentType: ShipmentTypeUi,
    val status: ShipmentStatusUi,
    val expiryDate: String?,
    val storedDate: String?,
    val pickUpDate: String?,
    val dateDisplayType: ShipmentDisplayDateTypeUi,
    val receiver: CustomerUi?,
    val sender: CustomerUi?,
    val operations: OperationsUi,
)

enum class ShipmentDisplayDateTypeUi {
    EXPIRY_DATE,
    STORED_DATE,
    PICKUP_DATE,
    NONE,
}
