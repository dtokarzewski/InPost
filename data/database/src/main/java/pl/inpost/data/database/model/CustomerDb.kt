package pl.inpost.data.database.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "customer",
    indices = [Index(value = ["email", "phoneNumber", "name"], unique = true)],
)
data class CustomerDb(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int = 0,
    val email: String?,
    val phoneNumber: String?,
    val name: String?
)
