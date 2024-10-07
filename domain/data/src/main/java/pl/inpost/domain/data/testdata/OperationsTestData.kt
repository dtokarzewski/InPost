package pl.inpost.domain.data.testdata

import pl.inpost.domain.data.Operations

fun operationsTestData() = Operations(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)
