package pl.inpost.shipmentlist.data.model.testdata

import pl.inpost.shipmentlist.data.model.OperationsUi

fun operationsUiTestData() = OperationsUi(
    delete = true,
    manualArchive = true,
    collect = true,
    highlight = true,
    expandAvizo = true,
    endOfWeekCollection = false,
)