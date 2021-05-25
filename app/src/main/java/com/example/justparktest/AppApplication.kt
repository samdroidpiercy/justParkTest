package com.example.justparktest

import android.app.Application
import com.example.justparktest.di.bookingsModule
import com.example.justparktest.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@AppApplication) }
        loadKoinModules(networkModule, bookingsModule)
    }

}