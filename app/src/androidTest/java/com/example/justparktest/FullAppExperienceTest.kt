package com.example.justparktest

import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class FullAppExperienceTest {
    @Rule
    @JvmField
    val rule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {}

    private val bookingsScreen by lazy { DriverBookingsFragmentScreen() }
    private val detailsScreen by lazy { DriverBookingDetailsScreen() }

    @Test
    fun should_run_through_the_app_precariously() {

        CountDownLatch(1).await(5000, TimeUnit.MILLISECONDS)

        bookingsScreen {
            loadingSpinner.isGone()
            bookings.firstChild<SimpleBookingItem> {
                title { hasText("JustPark Hotel Cookberg") }
                click()
            }
        }

        CountDownLatch(1).await(1500, TimeUnit.MILLISECONDS)

        detailsScreen {
            type { hasText("PREBOOK") }
        }

    }
}