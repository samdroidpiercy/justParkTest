package com.example.justparktest.data.entities

import com.google.gson.annotations.SerializedName

data class GetBookingsResponse(@SerializedName("data") val simpleBookings: List<SimpleBooking>)