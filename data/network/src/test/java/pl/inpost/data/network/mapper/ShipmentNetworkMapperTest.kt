package pl.inpost.data.network.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.model.testdata.shipmentNetworkTestData
import pl.inpost.domain.data.ShipmentStatus
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

    @Test
    fun `GIVEN ShipmentNetwork with unknown status WHEN mapped to Domain THEN return Shipment with OTHER status`() {
        val input = shipmentNetworkTestData().copy(status = null)
        val expected = shipmentTestData().copy(status = ShipmentStatus.OTHER)

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}