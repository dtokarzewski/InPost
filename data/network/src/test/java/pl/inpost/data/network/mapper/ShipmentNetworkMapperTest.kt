package pl.inpost.data.network.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.testdata.shipmentNetworkTestData
import pl.inpost.domain.data.testdata.shipmentTestData

class ShipmentNetworkMapperTest {
    private lateinit var sut: ShipmentNetworkMapper

    @Before
    fun setUp() {
        sut = ShipmentNetworkMapper(
            customerNetworkMapper = CustomerNetworkMapper(),
            eventLogNetworkMapper = EventLogNetworkMapper(),
            operationsNetworkMapper = OperationsNetworkMapper(),
            shipmentStatusNetworkMapper = ShipmentStatusNetworkMapper(),
            shipmentTypeNetworkMapper = ShipmentTypeNetworkMapper(),
        )
    }

    @Test
    fun `GIVEN ShipmentNetwork WHEN mapped to Domain THEN return Shipment`() {
        val input = shipmentNetworkTestData()
        val expected = shipmentTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}