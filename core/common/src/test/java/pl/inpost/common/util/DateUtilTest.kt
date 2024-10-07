package pl.inpost.common.util

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.time.ZonedDateTime

class DateUtilTest {

    @Test
    fun `GIVEN ZonedDateTime WHEN map to presentation string THEN return formatted string`() {
        val input = ZonedDateTime.parse("2022-11-29T04:56:07Z")
        val expected = "Tue. | 29.11.22 | 04:56"

        val actual = input.toPresentationString()

        assertEquals(expected, actual)
    }
}
