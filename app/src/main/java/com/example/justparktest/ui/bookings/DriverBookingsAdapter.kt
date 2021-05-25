package com.example.justparktest.ui.bookings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.justparktest.R
import com.example.justparktest.data.entities.SimpleBooking
import com.example.justparktest.databinding.ItemSimpleBookingBinding
import com.example.justparktest.utils.extensions.getCardDrawable

class DriverBookingsAdapter(private val simpleBookingsList: MutableList<SimpleBooking>,
                            private val onItemClick: (SimpleBooking) -> Unit): RecyclerView.Adapter<SimpleBookingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleBookingViewHolder {
        val binding = ItemSimpleBookingBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SimpleBookingViewHolder(binding)
    }


    override fun getItemCount(): Int =
       simpleBookingsList.size

    override fun onBindViewHolder(holder: SimpleBookingViewHolder, position: Int) {
        holder.onBind(simpleBookingsList[position], onItemClick)
    }

    fun updateBookings(bookings: List<SimpleBooking>){
        simpleBookingsList.addAll(bookings)
        notifyDataSetChanged()
    }

}

class SimpleBookingViewHolder(private val binding: ItemSimpleBookingBinding): RecyclerView.ViewHolder(binding.root){
    fun onBind(simpleBooking: SimpleBooking, onItemClick: (SimpleBooking) -> Unit){
        itemView.setOnClickListener { onItemClick(simpleBooking) }
        binding.title.text = simpleBooking.title
        binding.type.text = simpleBooking.type
        binding.cardImage.setImageDrawable(simpleBooking.getCardDrawable(itemView.resources))
        binding.cardNumber.text = "XXXX-XXXX-XXXX-${simpleBooking.paymentSource.data.lastFour}"
        binding.price.text = simpleBooking.driverPrice.data.formatted
    }

}