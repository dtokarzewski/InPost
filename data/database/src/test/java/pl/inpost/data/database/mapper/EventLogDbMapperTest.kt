package pl.inpost.data.database.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.data.database.model.testdata.eventLogDbTestData
import pl.inpost.domain.data.testdata.eventLogTestData
import javax.inject.Inject

class EventLogDbMapperTest @Inject constructor() {
    private lateinit var sut: EventLogDbMapper

    @Before
    fun setUp() {
        sut = EventLogDbMapper()
    }

    @Test
    fun `GIVEN EventLogDb WHEN mapped to Domain THEN return EventLog`() {
        val input = eventLogDbTestData().first()
        val expected = eventLogTestData().first()

        val actual = sut.toDomain(input)

        assertEquals(expected, actual)
    }
}