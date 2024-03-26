package com.example.skogbrynetsverkstad.data

import com.google.firebase.firestore.DocumentId

data class OrderItem(
    var itemName: String = "",
    var itemPrice: Double = 0.0,
   // var itemSize: Size?,
   // var itemColor: Color?,
   // var pricePerPackage: Double = 0.0,
   // var itemPackaging: Int = 1,
    var itemCount: Int = 0,
    @DocumentId var documentId : String? = null,
    )
