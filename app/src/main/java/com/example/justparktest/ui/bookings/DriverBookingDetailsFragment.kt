package com.example.justparktest.ui.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import coil.size.Scale
import com.example.justparktest.R
import com.example.justparktest.data.entities.BookingDetails
import com.example.justparktest.data.entities.SimpleBooking
import com.example.justparktest.databinding.FragmentDriverBookingDetailsBinding
import com.example.justparktest.utils.extensions.getCardDrawable
import com.example.justparktest.utils.extensions.makeBoldAndAppendWith
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

class DriverBookingDetailsFragment : Fragment() {


    private var _binding: FragmentDriverBookingDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DriverBookingDetailsViewModel by inject()
    private val subscriptions by lazy { CompositeDisposable() }

    private val simpleBooking by lazy {
        Gson().fromJson(arguments?.get("simpleBooking") as? String, SimpleBooking::class.java)
            ?: throw IllegalArgumentException("Booking id was not provided")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDriverBookingDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.type.text = simpleBooking.type
        binding.cardImage.setImageDrawable(simpleBooking.getCardDrawable(resources))
        binding.cardNumber.text = "XXXX-XXXX-XXXX-${simpleBooking.paymentSource.data.lastFour}"
        binding.price.text = simpleBooking.driverPrice.data.formatted
    }

    override fun onStart() {
        super.onStart()
        (activity as? AppCompatActivity)?.supportActionBar?.title = simpleBooking.title
        subscriptions.add(
            viewModel.getBooking(simpleBooking.id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bookingDetails: BookingDetails ->
                    binding.apply {
                        registration.text = getString(R.string.vehicleRegistration).makeBoldAndAppendWith(bookingDetails.vehicle.registration)
                        make.text = getString(R.string.vehicleMake).makeBoldAndAppendWith(bookingDetails.vehicle.make)
                        model.text = getString(R.string.vehicleModel).makeBoldAndAppendWith(bookingDetails.vehicle.model)
                        houseNumber.text = getString(R.string.houseNumber).makeBoldAndAppendWith(bookingDetails.address?.houseNo ?: getString(R.string.notAvailable))
                        addressFirstLine.text = getString(R.string.addressFirstLine).makeBoldAndAppendWith(bookingDetails.address?.address1 ?: getString(R.string.notAvailable))
                        city.text = getString(R.string.city).makeBoldAndAppendWith(bookingDetails.address?.city ?: getString(R.string.notAvailable))
                        postcode.text = getString(R.string.postcode).makeBoldAndAppendWith(bookingDetails.address?.postalCode ?: getString(R.string.notAvailable))
                        binding.staticMap.load(bookingDetails.staticMapURL)
                    }


            }
        )
    }


}