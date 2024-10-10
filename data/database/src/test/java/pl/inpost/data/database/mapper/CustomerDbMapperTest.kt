package pl.inpost.data.database.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.database.model.testdata.receiverDbTestData
import pl.inpost.domain.data.testdata.receiverTestData

class CustomerDbMapperTest {
    private lateinit var sut: CustomerDbMapper

    @Before
    fun setUp() {
        sut = CustomerDbMapper()
    }

    @Test
    fun `GIVEN CustomerDb WHEN mapped to Domain THEN return Customer`() {
        val input = receiverDbTestData()
        val expected = receiverTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}