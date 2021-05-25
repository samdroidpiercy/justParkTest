package com.example.justparktest.ui.bookings

import com.example.justparktest.data.entities.GetBookingsResponse
import com.example.justparktest.data.network.services.BookingsService
import com.example.justparktest.helpers.getSimpleBooking
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import org.junit.Test


class DriverBookingsViewModelTest{
    @Test
    fun ensureBookingIsExtracted(){

        val simpleBookingsList = listOf(getSimpleBooking(), getSimpleBooking(id = 241284214L, type = "best"))

        val bookingsService = mock<BookingsService>{
            on { getBookings() } doReturn Single.just(GetBookingsResponse(simpleBookingsList))
        }

        val viewModel = DriverBookingsViewModel(bookingsService)

        viewModel.getBookings().test().assertValue { it == simpleBookingsList }


    }
}