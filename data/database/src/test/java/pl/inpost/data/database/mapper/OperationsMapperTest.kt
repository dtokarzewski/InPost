package pl.inpost.data.database.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.database.testdata.operationsDbTestData
import pl.inpost.domain.data.testdata.operationsTestData

class OperationsMapperTest {
    private lateinit var sut: OperationsDbMapper

    @Before
    fun setUp() {
        sut = OperationsDbMapper()
    }

    @Test
    fun `GIVEN OperationsDb WHEN mapped to Domain THEN return Operations`() {
        val input = operationsDbTestData()
        val expected = operationsTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}