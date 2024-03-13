package com.example.skogbrynetsverkstad.data

data class Product(
    var productTitle: String = "",
    var productDescription: String = "",
    var productInformation: String = "",
    var productShortDescription: String = "",
    var productCategory: MutableList<String> =mutableListOf<String>(),
    var productPrimaryPicturePath: String = "",
    var productImagePaths: MutableList<String> =  mutableListOf<String>(),
    var availableDifferentColors: Boolean = false,
    var colors: MutableList<Color> = mutableListOf<Color>(),
    var availableDifferentSizes: Boolean = false,
    var sizes:MutableList<Size>? = mutableListOf<Size>(),
    var price: Double = 0.0,
    var packaging: Int = 1,
    var count: Int = 0,
    var needsCustomerInput: Boolean = false,
    var availability: Availability = Availability.AVAILABLE,
    var visibleOnHomepage: Boolean = false,



    ) {
        enum class Availability {
            AVAILABLE,
            UNAVAILABLE,
           CUSTOM_MADE
        }
    }
