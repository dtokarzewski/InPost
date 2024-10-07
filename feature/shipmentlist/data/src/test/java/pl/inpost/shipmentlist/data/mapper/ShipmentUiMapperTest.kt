package pl.inpost.shipmentlist.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import pl.inpost.domain.model.ShipmentStatus
import pl.inpost.domain.model.testdata.shipmentTestData
import pl.inpost.shipmentlist.data.data.ShipmentDisplayDateTypeUi
import pl.inpost.shipmentlist.data.data.ShipmentStatusUi
import pl.inpost.shipmentlist.data.data.testdata.shipmentUiTestData
import java.time.ZonedDateTime

class ShipmentUiMapperTest {

    private lateinit var sut: ShipmentUiMapper

    @Before
    fun setUp() {
        sut = ShipmentUiMapper(
            shipmentTypeUiMapper = ShipmentTypeUiMapper(),
            shipmentStatusUiMapper = ShipmentStatusUiMapper(),
            customerUiMapper = CustomerUiMapper(),
            operationsUiMapper = OperationsUiMapper(),
        )
    }

    @Test
    fun `GIVEN Shipment READY_TO_PICKUP with expiry date WHEN mapped to Ui THEN return ShipmentUi with EXPIRY_DATE date display type`() {
        val input = shipmentTestData()
        val expected = shipmentUiTestData()

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Shipment READY_TO_PICKUP with no expiry date WHEN mapped to Ui THEN return ShipmentUi with NONE date display type`() {
        val input = shipmentTestData().copy(
            expiryDate = null,
        )
        val expected = shipmentUiTestData().copy(
            expiryDate = null,
            dateDisplayType = ShipmentDisplayDateTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Shipment DELIVERED with pickup date WHEN mapped to Ui THEN return ShipmentUi with PICKUP_DATE date display type`() {
        val input = shipmentTestData().copy(
            status = ShipmentStatus.DELIVERED,
            pickUpDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
        )
        val expected = shipmentUiTestData().copy(
            status = ShipmentStatusUi.DELIVERED,
            pickUpDate = "tue. | 29.11.22 | 04:56",
            dateDisplayType = ShipmentDisplayDateTypeUi.PICKUP_DATE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Shipment DELIVERED with no pickup date WHEN mapped to Ui THEN return ShipmentUi with NONE date display type`() {
        val input = shipmentTestData().copy(
            status = ShipmentStatus.DELIVERED,
            pickUpDate = null,
        )
        val expected = shipmentUiTestData().copy(
            status = ShipmentStatusUi.DELIVERED,
            pickUpDate = null,
            dateDisplayType = ShipmentDisplayDateTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Shipment EXPIRED with expiry date WHEN mapped to Ui THEN return ShipmentUi with EXPIRY_DATE date display type`() {
        val input = shipmentTestData().copy(
            status = ShipmentStatus.PICKUP_TIME_EXPIRED,
            expiryDate = ZonedDateTime.parse("2022-11-29T04:56:07Z"),
            pickUpDate = null,
        )
        val expected = shipmentUiTestData().copy(
            status = ShipmentStatusUi.PICKUP_TIME_EXPIRED,
            expiryDate = "tue. | 29.11.22 | 04:56",
            pickUpDate = null,
            dateDisplayType = ShipmentDisplayDateTypeUi.EXPIRY_DATE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN Shipment EXPIRED with no expiry date WHEN mapped to Ui THEN return ShipmentUi with NONE date display type`() {
        val input = shipmentTestData().copy(
            status = ShipmentStatus.PICKUP_TIME_EXPIRED,
            expiryDate = null,
            pickUpDate = null,
        )
        val expected = shipmentUiTestData().copy(
            status = ShipmentStatusUi.PICKUP_TIME_EXPIRED,
            expiryDate = null,
            pickUpDate = null,
            dateDisplayType = ShipmentDisplayDateTypeUi.NONE,
        )

        val actual = sut.toUi(input)

        assertEquals(expected, actual)
    }
}
