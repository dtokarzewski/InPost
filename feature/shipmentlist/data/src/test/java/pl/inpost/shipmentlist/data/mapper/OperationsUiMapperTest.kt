package pl.inpost.shipmentlist.data.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.model.testdata.operationsTestData
import pl.inpost.shipmentlist.data.data.testdata.operationsUiTestData

class OperationsUiMapperTest {

    private lateinit var sut: OperationsUiMapper

    @Before
    fun setUp() {
        sut = OperationsUiMapper()
    }

    @Test
    fun `GIVEN Operations WHEN mapped to Ui THEN return OperationsUi`() {
        val input = operationsTestData()
        val expected = operationsUiTestData()

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }
}