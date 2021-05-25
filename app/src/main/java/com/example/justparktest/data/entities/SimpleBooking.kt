package com.example.justparktest.data.entities

import com.google.gson.annotations.SerializedName

data class SimpleBooking(
    val id: Long,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("driver_id") val driverID: Long,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("payment_source") val paymentSource: PaymentSource,
    val type: String,
    val title: String,
    @SerializedName("owner_id") val ownerID: Long,
    @SerializedName("driver_price") val driverPrice: DriverPrice,
    val timezone: String,
    val photos: List<String>,
    @SerializedName("auto_pay") val autoPay: Boolean,
    val status: String,
    val infinite: Boolean
)

data class DriverPrice (
    val data: DriverPriceData
)

data class DriverPriceData (
    val id: String,
    val value: Double,
    val currency: String,
    val pennies: Long,
    val formatted: String
)

data class PaymentSource (
    val data: PaymentSourceData
)

data class PaymentSourceData (
    val source: String,
    @SerializedName("card_type") val cardType: String,
    @SerializedName("last_four") val lastFour: String,
    val id: Long,
    @SerializedName("expiry_date") val expiryDate: String
)
