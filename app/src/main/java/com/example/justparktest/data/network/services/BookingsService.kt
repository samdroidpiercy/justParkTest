package com.example.justparktest.data.network.services

import com.example.justparktest.data.entities.GetBookingDetailsResponse
import com.example.justparktest.data.entities.GetBookingsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BookingsService {
    @GET("samdroidpiercy/jptest/main/bookings.json")
    fun getBookings(): Single<GetBookingsResponse>

    @GET("samdroidpiercy/jptest/main/booking/{bookingId}.json")
    fun getBookingDetails(@Path("bookingId") bookingId: String): Single<GetBookingDetailsResponse>
}