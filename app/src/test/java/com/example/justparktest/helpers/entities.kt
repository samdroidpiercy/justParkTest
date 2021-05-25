package com.example.justparktest.helpers

import com.example.justparktest.data.entities.*

fun getSimpleBooking(id: Long = 12341, startDate: String = "start", driverID: Long = 2134,
                     endDate: String = "sdaas",
                     paymentSource: PaymentSource = PaymentSource(data = PaymentSourceData("", "", "", 23, "")),
                     type: String = "type",
                     title: String = "title",
                     ownerID: Long = 2145,
                     driverPrice: DriverPrice = DriverPrice(data = DriverPriceData(id = "", value = 5.0, currency = "wahtever", pennies = 23142L, formatted = "" )),
                     timezone: String = "",
                     photos: List<String> = listOf(""),
                     autoPay: Boolean = false,
                     status: String = "",
                     infinite: Boolean = false) =
    SimpleBooking(id = id, startDate = startDate, driverID = driverID,
    endDate = endDate, paymentSource = paymentSource,
    type = type, title = title, ownerID = ownerID, driverPrice = driverPrice,
    timezone = timezone, photos = photos, autoPay = autoPay, status = status, infinite = infinite)