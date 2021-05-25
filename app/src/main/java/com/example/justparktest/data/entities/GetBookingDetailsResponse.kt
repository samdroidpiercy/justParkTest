package com.example.justparktest.data.entities

import com.google.gson.annotations.SerializedName

class GetBookingDetailsResponse(@SerializedName("data") val bookingDetails: BookingDetails) {
}