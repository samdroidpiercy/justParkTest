package com.example.justparktest.di

import com.example.justparktest.ui.bookings.DriverBookingDetailsViewModel
import com.example.justparktest.ui.bookings.DriverBookingsViewModel
import org.koin.dsl.module

val bookingsModule = module {

    factory {
        DriverBookingsViewModel(get())
    }

    factory {
        DriverBookingDetailsViewModel(get())
    }
}

