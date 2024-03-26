package com.example.skogbrynetsverkstad.data

import com.google.firebase.firestore.DocumentId

data class OrderDetails(
    var orderDatum: String? = null,
    var orderNumber:Int? = null,
    //TODO back to double - convert to double
    var totalSum:Int? = null,
   // var customerDetails: CustomerDetails = CustomerDetails(),
   // var messageFromCustomer:String? = null,
    var orderItems: MutableList<OrderItem> = mutableListOf<OrderItem>(),
    @DocumentId var documentId: String? = null
)
