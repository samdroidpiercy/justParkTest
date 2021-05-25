package com.example.justparktest.ui.bookings

import com.example.justparktest.data.entities.BookingDetails
import com.example.justparktest.data.network.services.BookingsService
import io.reactivex.Single

class DriverBookingDetailsViewModel(private val bookingsService: BookingsService) {

    fun getBooking(bookingId: Long): Single<BookingDetails> =
        bookingsService.getBookingDetails(bookingId.toString())
            .map { it.bookingDetails }

}