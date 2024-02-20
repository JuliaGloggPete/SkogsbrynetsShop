package com.example.skogbrynetsverkstad.data

import com.example.skogbrynetsverkstad.data.OrderDetails

data class Invoice(
    var ownerName: String = "Victoria Erlingsson",
    var orgNr: String = "0000-placeholder",
    var ownerAddress: String = "",
    var ownerCity: String = "Vittsjö",
    var ownerPostalCode: String = "282 XX",
    var phoneNumber: String = "070 XXXX",
    var eMail: String = "placeholder.com",
    var discountProcent: Int?,
    var discountCrowns: Int?,
    var extraInformation: String?,
    var invoiceNumber: String = "",
    var orderDetails: OrderDetails = OrderDetails(),

    )
