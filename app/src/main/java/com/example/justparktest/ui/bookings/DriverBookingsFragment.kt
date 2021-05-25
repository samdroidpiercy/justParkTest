package com.example.justparktest.ui.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justparktest.R
import com.example.justparktest.data.entities.SimpleBooking
import com.example.justparktest.databinding.FragmentDriverBookingsBinding
import com.example.justparktest.di.bookingsModule
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

class DriverBookingsFragment : Fragment() {

    private var _binding: FragmentDriverBookingsBinding? = null
    private val binding get() = _binding!!
    private val subscriptions by lazy { CompositeDisposable() }
    private val adapter = DriverBookingsAdapter(mutableListOf()) { findNavController().navigate(R.id.expandBookingDetails, Bundle().apply { putString("simpleBooking", Gson().toJson(it)) }) }

    companion object {
        operator fun invoke() = DriverBookingsFragment()
    }

    private val viewModel: DriverBookingsViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDriverBookingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.bookingsTitle)

        binding.recyclerView.apply{
            adapter = this@DriverBookingsFragment.adapter
            layoutManager = GridLayoutManager(activity, if(resources.getBoolean(R.bool.isLargeScreen)) 2 else 1)
        }
    }

    override fun onStart() {
        super.onStart()

        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.bookingsTitle)

        if(adapter.itemCount == 0) {
            subscriptions.add(
                viewModel.getBookings()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { simpleBookingsList: List<SimpleBooking> ->
                        binding.loadingSpinner.visibility = View.GONE
                        adapter.updateBookings(simpleBookingsList)
                    }
            )
        }
        else binding.loadingSpinner.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        subscriptions.dispose()
        super.onDestroy()
    }
}