package pl.inpost.data.network.mapper

import org.junit.Assert.*
import org.junit.Test
import pl.inpost.data.network.model.ShipmentStatusNetwork
import pl.inpost.domain.data.ShipmentStatus

class ShipmentStatusNetworkMapperTest {

    @Test
    fun `GIVEN ShipmentStatusNetwork WHEN mapped to Domain THEN return ShipmentStatus`() {
        val input = ShipmentStatusNetwork.entries.toTypedArray()
        val expected = ShipmentStatus.entries.toTypedArray()

        val actual = input.map { ShipmentStatusNetworkMapper().toDomain(it) }

        assertArrayEquals(expected, actual.toTypedArray())
    }
}
