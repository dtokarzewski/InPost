package pl.inpost.data.network.mapper

import pl.inpost.data.network.model.OperationsNetwork
import pl.inpost.domain.data.Operations
import javax.inject.Inject

class OperationsNetworkMapper @Inject constructor() {
    fun toDomain(operations: OperationsNetwork) = with(operations) {
        Operations(
            manualArchive = manualArchive,
            delete = delete,
            collect = collect,
            highlight = highlight,
            expandAvizo = expandAvizo,
            endOfWeekCollection = endOfWeekCollection
        )
    }
}
