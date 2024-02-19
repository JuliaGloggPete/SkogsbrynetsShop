package com.example.skogbrynetsverkstad.data

data class OrderDetails(
    var orderDate: String? = null,
    var orderNr:Int? = null,
    var totalAmount:Double? = null,
    var customerDetails: CustomerDetails = CustomerDetails(),
    var messageFromCustomer:String? = null,
    var orderItems: MutableList<OrderItem> = mutableListOf<OrderItem>(),
)
