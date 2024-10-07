package pl.inpost.domain.usecase

import kotlinx.coroutines.flow.Flow
import pl.inpost.domain.data.Shipment
import pl.inpost.domain.repository.ShipmentRepository
import javax.inject.Inject

class GetStandardShipmentsAsFlowUseCase @Inject constructor(
    private val shipmentRepository: ShipmentRepository,
) {
    operator fun invoke(): Flow<List<Shipment>> =
        shipmentRepository.getStandardShipmentsAsFlow()
}
