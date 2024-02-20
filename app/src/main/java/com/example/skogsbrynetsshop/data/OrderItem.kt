package com.example.skogbrynetsverkstad.data

data class OrderItem(
    var itemName: String = "",
    var itemSize: Size?,
    var itemColor: Color?,
    var pricePerPackage: Double = 0.0,
    var itemPackaging: Int = 1,
    var itemOrdered: Int = 0,

    )
