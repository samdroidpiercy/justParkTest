package com.example.justparktest.utils.extensions

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.content.res.ResourcesCompat
import com.example.justparktest.R
import com.example.justparktest.data.entities.SimpleBooking

fun SimpleBooking.getCardDrawable(resources: Resources): Drawable? =
    when(paymentSource.data.cardType.toLowerCase()){
        "visa" -> ResourcesCompat.getDrawable(resources, R.drawable.visa, null)
        "mastercard" -> ResourcesCompat.getDrawable(resources, R.drawable.mastercard, null)
        else -> ResourcesCompat.getDrawable(resources, R.drawable.unknown_card, null)
    }

fun String.makeBoldAndAppendWith(suffix: String): SpannableStringBuilder =
    SpannableStringBuilder("$this $suffix").apply {
        setSpan(
            android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
            0,
            this@makeBoldAndAppendWith.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }



