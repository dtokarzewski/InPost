package pl.inpost.domain.usecase

import pl.inpost.domain.repository.ShipmentRepository
import javax.inject.Inject

class HideShipmentUseCase @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
) {
    operator fun invoke(shipmentNumber: String) {
        shipmentRepository.hideShipment(shipmentNumber)
    }
}
