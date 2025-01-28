package com.example.justparktest.di

import com.example.justparktest.data.network.services.BookingsService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .client(get())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    factory<BookingsService> { get<Retrofit>().create(BookingsService::class.java) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }
}

