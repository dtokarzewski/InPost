package pl.inpost.data.database.mapper

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import pl.inpost.data.database.model.ShipmentStatusDb
import pl.inpost.domain.data.ShipmentStatus

class ShipmentStatusDbMapperTest {

    @Test
    fun `GIVEN ShipmentStatusDb WHEN mapped to Domain THEN return ShipmentStatus`() {
        val input = ShipmentStatusDb.entries.toTypedArray()
        val expected = ShipmentStatus.entries.toTypedArray()

        val actual = input.map { ShipmentStatusDbMapper().toDomain(it) }

        assertArrayEquals(expected, actual.toTypedArray())
    }
}
