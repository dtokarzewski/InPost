package pl.inpost.data.database.testdata

import pl.inpost.data.database.model.OperationsDb

fun operationsDbTestData() = OperationsDb(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)
