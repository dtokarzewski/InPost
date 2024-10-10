package pl.inpost.data.database.mapper

import pl.inpost.data.database.model.OperationsDb
import pl.inpost.domain.data.Operations
import javax.inject.Inject

class OperationsDbMapper @Inject constructor() {
    fun toDomain(operations: OperationsDb) = with(operations) {
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
