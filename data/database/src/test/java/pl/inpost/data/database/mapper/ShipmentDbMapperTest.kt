package pl.inpost.data.database.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.database.model.testdata.populatedShipmentDbTestData
import pl.inpost.data.network.mapper.ShipmentTypeDbMapper
import pl.inpost.domain.data.testdata.shipmentTestData

class ShipmentDbMapperTest {
    private lateinit var sut: ShipmentDbMapper

    @Before
    fun setUp() {
        sut = ShipmentDbMapper(
            customerNetworkMapper = CustomerDbMapper(),
            eventLogMapper = EventLogDbMapper(),
            operationsMapper = OperationsDbMapper(),
            shipmentStatusMapper = ShipmentStatusDbMapper(),
            shipmentTypeMapper = ShipmentTypeDbMapper(),
        )
    }

    @Test
    fun `GIVEN ShipmentDb WHEN mapped to Domain THEN return Shipment`() {
        val input = populatedShipmentDbTestData()
        val expected = shipmentTestData()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}