package pl.inpost.data.network.api

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import pl.inPost.data.network.R
import pl.inpost.data.network.typeadapter.ApiTypeAdapter
import pl.inpost.data.network.model.CustomerNetwork
import pl.inpost.data.network.model.EventLogNetwork
import pl.inpost.data.network.model.OperationsNetwork
import pl.inpost.data.network.model.ShipmentNetwork
import pl.inpost.data.network.model.ShipmentStatusNetwork
import pl.inpost.data.network.model.ShipmentTypeNetwork
import pl.inpost.data.network.model.ShipmentsResponse
import java.time.ZonedDateTime
import kotlin.random.Random

class FakeShipmentApi(
    @ApplicationContext private val context: Context,
    apiTypeAdapter: ApiTypeAdapter
) : ShipmentApi {

    private val response by lazy {
        val json = context.resources.openRawResource(R.raw.mock_shipment_api_response)
            .bufferedReader()
            .use { it.readText() }

        val jsonAdapter = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(apiTypeAdapter)
            .add(ShipmentStatusNetwork::class.java,EnumJsonAdapter
                .create(ShipmentStatusNetwork::class.java)
                .withUnknownFallback(ShipmentStatusNetwork.OTHER)
            )
            .build()
            .adapter(ShipmentsResponse::class.java)

        jsonAdapter.fromJson(json) as ShipmentsResponse
    }

    override suspend fun getShipments(): List<ShipmentNetwork> {
        delay(1000)
        return response.shipments
    }
}

private fun mockShipmentNetwork(
    number: String = Random.nextLong(1, 9999_9999_9999_9999).toString(),
    type: ShipmentTypeNetwork = ShipmentTypeNetwork.PARCEL_LOCKER,
    status: ShipmentStatusNetwork = ShipmentStatusNetwork.DELIVERED,
    sender: CustomerNetwork? = mockCustomerNetwork(),
    receiver: CustomerNetwork? = mockCustomerNetwork(),
    operations: OperationsNetwork = mockOperationsNetwork(),
    eventLog: List<EventLogNetwork> = emptyList(),
    openCode: String? = null,
    expireDate: ZonedDateTime? = null,
    storedDate: ZonedDateTime? = null,
    pickupDate: ZonedDateTime? = null
) = ShipmentNetwork(
    number = number,
    shipmentType = type,
    status = status,
    eventLog = eventLog,
    openCode = openCode,
    expiryDate = expireDate,
    storedDate = storedDate,
    pickUpDate = pickupDate,
    receiver = receiver,
    sender = sender,
    operations = operations
)

private fun mockCustomerNetwork(
    email: String = "name@email.com",
    phoneNumber: String = "123 123 123",
    name: String = "Jan Kowalski"
) = CustomerNetwork(
    email = email,
    phoneNumber = phoneNumber,
    name = name
)

private fun mockOperationsNetwork(
    manualArchive: Boolean = false,
    delete: Boolean = false,
    collect: Boolean = false,
    highlight: Boolean = false,
    expandAvizo: Boolean = false,
    endOfWeekCollection: Boolean = false
) = OperationsNetwork(
    manualArchive = manualArchive,
    delete = delete,
    collect = collect,
    highlight = highlight,
    expandAvizo = expandAvizo,
    endOfWeekCollection = endOfWeekCollection
)
