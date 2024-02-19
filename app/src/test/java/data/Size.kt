package com.example.skogbrynetsverkstad.data

data class Size(
    val size: String = "",
    val sizeExtraCost: Double? = null,
    var availabilitySize: Availability = Availability.AVAILABLE
) {
    enum class Availability {
        AVAILABLE,
        UNAVAILABLE,
        CUSTOMMADE,
    }
}

