package pl.dtokarzewski.data

data class ShipmentUi(
    val number: String,
    val shipmentType: ShipmentTypeUi,
    val status: ShipmentStatusUi,
    val statusDate: String?,
    val receiver: String?,
    val sender: String?,
    val operations: OperationsUi,
)
