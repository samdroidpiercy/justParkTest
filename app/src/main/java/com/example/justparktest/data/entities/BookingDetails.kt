package com.example.justparktest.data.entities

import com.google.gson.annotations.SerializedName

data class BookingDetails(
    @SerializedName("created_at") val createdAt: String,
    val id: Long,
    @SerializedName("access_instructions") val accessInstructions: String,
    @SerializedName("driver_total") val driverTotal: DriverTotal,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("payment_method") val paymentMethod: PaymentMethod,
    val status: String,
    @SerializedName("start_date") val startDate: String,
    val vehicle: Vehicle,
    val listing: Listing,
    val title: String,
    val description: String,
    val lng: String,
    val type: String,
    val address: Address?,
    @SerializedName("number_of_spaces") val numberOfSpaces: Long,
    val facilities: List<Facility>,
    @SerializedName("location_instructions") val locationInstructions: Any? = null,
    val lat: String,
    @SerializedName("static_map_url") val staticMapURL: String,
    val category: String,
    val photos: List<Any?>
)

data class Address(
    val location: Location,
    val city: String,
    val address1: String,
    val id: Long,
    val country: String,
    @SerializedName("house_no") val houseNo: String,
    @SerializedName("postal_code") val postalCode: String,
    val address3: Any? = null,
    val state: Any? = null,
    val address2: Any? = null
)

data class Location(
    val lat: Double,
    val lng: Double
)

data class DriverTotal(
    val value: Double,
    val formatted: String
)

data class Facility(
    val id: String,
    val title: String,
    @SerializedName("is_restricted") val isRestricted: Boolean,
    val description: String,
    val hidden: Boolean
)

data class Listing(
    val id: Long,
    val feedback: Feedback
)

data class Feedback(
    val count: Long,
    @SerializedName("average_rating") val averageRating: Double
)

data class PaymentMethod(
    val id: Long,
    @SerializedName("expiry_date") val expiryDate: String,
    val source: String,
    @SerializedName("card_type") val cardType: String,
    @SerializedName("last_four") val lastFour: String,
    val name: String
)

data class Vehicle(
    val id: Long,
    val registration: String,
    @SerializedName("model_id") val modelID: String,
    @SerializedName("fuel_type") val fuelType: Any? = null,
    val make: String,
    @SerializedName("hire_company") val hireCompany: Any? = null,
    val model: String,
    @SerializedName("is_hired") val isHired: Boolean,
    @SerializedName("is_primary") val isPrimary: Boolean
)