package pl.inpost.data.network.model.testdata

import pl.inpost.data.network.model.OperationsNetwork

fun operationsNetworkTestData() = OperationsNetwork(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)
