package com.example.justparktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.justparktest.ui.bookings.DriverBookingDetailsFragment
import com.example.justparktest.ui.bookings.DriverBookingsFragment
import com.example.justparktest.ui.bookings.DriverBookingsViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}