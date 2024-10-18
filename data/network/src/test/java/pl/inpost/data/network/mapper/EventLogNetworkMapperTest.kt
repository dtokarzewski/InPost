package pl.inpost.data.network.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.inpost.data.network.testdata.eventLogNetworkTestData
import pl.inpost.domain.data.testdata.eventLogTestData
import javax.inject.Inject

class EventLogNetworkMapperTest @Inject constructor() {
    private lateinit var sut: EventLogNetworkMapper

    @Before
    fun setUp() {
        sut = EventLogNetworkMapper()
    }

    @Test
    fun `GIVEN EventLogNetwork WHEN mapped to Domain THEN return EventLog`() {
        val input = eventLogNetworkTestData().first()
        val expected = eventLogTestData().first()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}