package pl.inpost.data.database.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.database.model.ShipmentTypeDb
import pl.inpost.data.network.mapper.ShipmentTypeDbMapper
import pl.inpost.domain.data.ShipmentType

class ShipmentTypeDbMapperTest {
    private lateinit var sut: ShipmentTypeDbMapper

    @Before
    fun setUp() {
        sut = ShipmentTypeDbMapper()
    }

    @Test
    fun `GIVEN ShipmentType COURIER WHEN mapped to Domain THEN return ShipmentType COURIER`() {
        val input = ShipmentTypeDb.COURIER
        val expected = ShipmentType.COURIER

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN ShipmentType PARCEL_LOCKER WHEN mapped to Domain THEN return ShipmentType PARCEL_LOCKER`() {
        val input = ShipmentTypeDb.PARCEL_LOCKER
        val expected = ShipmentType.PARCEL_LOCKER

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}