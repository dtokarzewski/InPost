package pl.inpost.domain.usecase

import pl.inpost.domain.repository.ShipmentRepository
import javax.inject.Inject

class RefreshShipmentsUseCase @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
) {
    suspend operator fun invoke() = shipmentRepository.refreshShipments()
}