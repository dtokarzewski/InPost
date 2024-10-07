package pl.inpost.domain.model.testdata

import pl.inpost.domain.model.Operations

fun operationsTestData() = Operations(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)
