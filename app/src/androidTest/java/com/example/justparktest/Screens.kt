package com.example.justparktest

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.progress.KProgressBar
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher

class DriverBookingsFragmentScreen: Screen<DriverBookingsFragmentScreen>() {
    val bookings = KRecyclerView({ withId(R.id.recyclerView) },
        itemTypeBuilder = { itemType(::SimpleBookingItem) } )
    val loadingSpinner = KProgressBar { withId(R.id.loadingSpinner) }
}

class SimpleBookingItem(parent: Matcher<View>): KRecyclerItem<SimpleBookingItem>(parent) {
    val title = KTextView(parent) { withId(R.id.title) }

}

class DriverBookingDetailsScreen: Screen<DriverBookingDetailsScreen>() {
    val type = KTextView{ withId(R.id.type) }
}