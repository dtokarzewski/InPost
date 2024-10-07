package pl.inpost.shipmentlist.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.model.Customer
import pl.inpost.domain.model.testdata.senderTestData
import pl.inpost.shipmentlist.data.data.CustomerDisplayTypeUi
import pl.inpost.shipmentlist.data.data.CustomerUi
import pl.inpost.shipmentlist.data.data.testdata.senderUiTestData

class CustomerUiMapperTest {

    private lateinit var sut: CustomerUiMapper

    @Before
    fun setUp() {
        sut = CustomerUiMapper()
    }

    @Test
    fun `GIVEN Customer with all fields filled WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData()
        val expected = senderUiTestData()

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with null name WHEN map to Ui THEN return CustomerUi with EMAIL display type`() {
        val input = senderTestData().copy(name = null)
        val expected = senderUiTestData().copy(
            name = null,
            displayType = CustomerDisplayTypeUi.EMAIL
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with blank name WHEN map to Ui THEN return CustomerUi with EMAIL display type`() {
        val input = senderTestData().copy(name = " ")
        val expected = senderUiTestData().copy(
            name = " ",
            displayType = CustomerDisplayTypeUi.EMAIL
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with empty name WHEN map to Ui THEN return CustomerUi with EMAIL display type`() {
        val input = senderTestData().copy(name = "")
        val expected = senderUiTestData().copy(
            name = "",
            displayType = CustomerDisplayTypeUi.EMAIL
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with null email WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(email = null)
        val expected = senderUiTestData().copy(
            email = null,
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with blank email WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(email = " ")
        val expected = senderUiTestData().copy(
            email = " ",
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with empty email WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(email = "")
        val expected = senderUiTestData().copy(
            email = "",
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with null phoneNumber WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(phoneNumber = null)
        val expected = senderUiTestData().copy(
            phoneNumber = null,
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with blank phoneNumber WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(phoneNumber = " ")
        val expected = senderUiTestData().copy(
            phoneNumber = " ",
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with empty phoneNumber WHEN map to Ui THEN return CustomerUi with NAME display type`() {
        val input = senderTestData().copy(phoneNumber = "")
        val expected = senderUiTestData().copy(
            phoneNumber = "",
            displayType = CustomerDisplayTypeUi.NAME
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with empty email and name WHEN map to Ui THEN return CustomerUi with PHONE_NUMBER display type`() {
        val input = senderTestData().copy(
            name = "",
            email = "",
        )
        val expected = senderUiTestData().copy(
            name = "",
            email = "",
            displayType = CustomerDisplayTypeUi.PHONE_NUMBER
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with blank email and name  WHEN map to Ui THEN return CustomerUi with PHONE_NUMBER display type`() {
        val input = senderTestData().copy(
            name = "",
            email = "",
        )
        val expected = senderUiTestData().copy(
            name = "",
            email = "",
            displayType = CustomerDisplayTypeUi.PHONE_NUMBER
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with empty email and name  WHEN map to Ui THEN return CustomerUi with PHONE_NUMBER display type`() {
        val input = senderTestData().copy(
            name = "",
            email = "",
            )
        val expected = senderUiTestData().copy(
            name = "",
            email = "",
            displayType = CustomerDisplayTypeUi.PHONE_NUMBER
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with all fields null WHEN map to Ui THEN return CustomerUi with NONE display type`() {
        val input = Customer(
            email = null,
            phoneNumber = null,
            name = null
        )
        val expected = CustomerUi(
            email = null,
            phoneNumber = null,
            name = null,
            displayType = CustomerDisplayTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with all fields blank  WHEN map to Ui THEN return CustomerUi with NONE display type`() {
        val input = Customer(
            email = " ",
            phoneNumber = " ",
            name = " "
        )
        val expected = CustomerUi(
            email = " ",
            phoneNumber = " ",
            name = " ",
            displayType = CustomerDisplayTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Customer with all fields blank WHEN map to Ui THEN return CustomerUi with NONE display type`() {
        val input = Customer(
            email = "",
            phoneNumber = "",
            name = ""
        )
        val expected = CustomerUi(
            email = "",
            phoneNumber = "",
            name = "",
            displayType = CustomerDisplayTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }
}