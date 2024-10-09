package pl.inpost.data.network.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.model.ShipmentTypeNetwork
import pl.inpost.domain.data.ShipmentType

class ShipmentTypeNetworkMapperTest {
    private lateinit var sut: ShipmentTypeNetworkMapper

    @Before
    fun setUp() {
        sut = ShipmentTypeNetworkMapper()
    }

    @Test
    fun `GIVEN ShipmentType COURIER WHEN mapped to Domain THEN return ShipmentType COURIER`() {
        val input = ShipmentTypeNetwork.COURIER
        val expected = ShipmentType.COURIER

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN ShipmentType PARCEL_LOCKER WHEN mapped to Domain THEN return ShipmentType PARCEL_LOCKER`() {
        val input = ShipmentTypeNetwork.PARCEL_LOCKER
        val expected = ShipmentType.PARCEL_LOCKER

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}