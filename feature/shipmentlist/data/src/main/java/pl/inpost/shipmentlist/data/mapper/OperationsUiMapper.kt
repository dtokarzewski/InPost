package pl.inpost.shipmentlist.data.mapper

import javax.inject.Inject
import pl.inpost.domain.model.Operations
import pl.inpost.shipmentlist.data.data.OperationsUi

class OperationsUiMapper @Inject constructor() {
    fun toUi(operations: Operations) = with(operations) {
        OperationsUi(
            manualArchive = manualArchive,
            delete = delete,
            collect = collect,
            highlight = highlight,
            expandAvizo = expandAvizo,
            endOfWeekCollection = endOfWeekCollection,
        )
    }
}
