package pl.inpost.shipmentlist.data.mapper

import org.junit.Assert.*
import org.junit.Test
import pl.inpost.domain.data.ShipmentStatus
import pl.inpost.shipmentlist.data.model.ShipmentStatusUi

class ShipmentStatusUiMapperTest {

    @Test
    fun `GIVEN ShipmentStatus WHEN mapped to Ui THEN return ShipmentStatusUi`() {
        val input = ShipmentStatus.entries.toTypedArray()
        val expected = ShipmentStatusUi.entries.toTypedArray()

        val actual = input.map { ShipmentStatusUiMapper().toUi(it) }

        assertArrayEquals(expected, actual.toTypedArray())
    }
}