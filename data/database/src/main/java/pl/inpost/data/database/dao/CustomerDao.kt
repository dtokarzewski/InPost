package pl.inpost.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import pl.inpost.data.database.model.CustomerDb

@Dao
interface CustomerDao {

    @Upsert
    suspend fun upsert(customer: CustomerDb): Long

    @Upsert
    suspend fun upsertAll(customers: List<CustomerDb>): List<Long>

    @Query("SELECT * FROM customer WHERE email = :email")
    fun getCustomerByEmail(email: String): Flow<CustomerDb>

}