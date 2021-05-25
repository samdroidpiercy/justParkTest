package com.example.justparktest.data.network.services

import com.example.justparktest.data.entities.GetBookingDetailsResponse
import com.example.justparktest.data.entities.GetBookingsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BookingsService {
    @GET("api/bookings")
    fun getBookings(): Single<GetBookingsResponse>

    @GET("api/booking/{bookingId}")
    fun getBookingDetails(@Path("bookingId") bookingId: String): Single<GetBookingDetailsResponse>
}