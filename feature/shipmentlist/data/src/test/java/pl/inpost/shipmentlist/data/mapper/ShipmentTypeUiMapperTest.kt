package pl.inpost.shipmentlist.data.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.model.ShipmentType
import pl.inpost.shipmentlist.data.data.ShipmentTypeUi

class ShipmentTypeUiMapperTest {

    private lateinit var sut: ShipmentTypeUiMapper

    @Before
    fun setUp() {
        sut = ShipmentTypeUiMapper()
    }

    @Test
    fun `GIVEN ShipmentType COURIER WHEN mapped to Ui THEN return ShipmentTypeUi COURIER`() {
        val input = ShipmentType.COURIER
        val expected = ShipmentTypeUi.COURIER

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN ShipmentType PARCEL_LOCKER WHEN mapped to Ui THEN return ShipmentTypeUi PARCEL_LOCKER`() {
        val input = ShipmentType.PARCEL_LOCKER
        val expected = ShipmentTypeUi.PARCEL_LOCKER

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }
}