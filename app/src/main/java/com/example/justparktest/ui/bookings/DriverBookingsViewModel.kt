package com.example.justparktest.ui.bookings

import com.example.justparktest.data.entities.SimpleBooking
import com.example.justparktest.data.network.services.BookingsService
import io.reactivex.Single

class DriverBookingsViewModel(private val bookingsService: BookingsService) {

    fun getBookings(): Single<List<SimpleBooking>> =
        bookingsService.getBookings()
            .map { it.simpleBookings }

}