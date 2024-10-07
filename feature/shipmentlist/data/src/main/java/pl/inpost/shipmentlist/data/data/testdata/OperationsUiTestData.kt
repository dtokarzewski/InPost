package pl.inpost.shipmentlist.data.data.testdata

import pl.inpost.shipmentlist.data.data.OperationsUi

fun operationsUiTestData() = OperationsUi(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)