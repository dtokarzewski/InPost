package pl.inpost.data.network.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.model.testdata.receiverNetworkTestData
import pl.inpost.domain.data.testdata.receiverTestData

class CustomerNetworkMapperTest {
    private lateinit var sut: CustomerNetworkMapper

    @Before
    fun setUp() {
        sut = CustomerNetworkMapper()
    }

    @Test
    fun `GIVEN CustomerNetwork WHEN mapped to Domain THEN return Customer`() {
        val input = receiverNetworkTestData()
        val expected = receiverTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}