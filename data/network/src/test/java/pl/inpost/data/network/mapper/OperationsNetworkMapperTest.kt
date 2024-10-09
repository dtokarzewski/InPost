package pl.inpost.data.network.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.model.testdata.operationsNetworkTestData
import pl.inpost.domain.data.testdata.operationsTestData

class OperationsNetworkMapperTest {
    private lateinit var sut: OperationsNetworkMapper

    @Before
    fun setUp() {
        sut = OperationsNetworkMapper()
    }

    @Test
    fun `GIVEN OperationsNetwork WHEN mapped to Domain THEN return Operations`() {
        val input = operationsNetworkTestData()
        val expected = operationsTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}