package com.example.skogbrynetsverkstad.data

data class Color(
    val colorName: String = "",
    val colorExtraCost: Double? = null,
    var availabilityColor: Availability = Availability.AVAILABLE
) {
    enum class Availability {
        AVAILABLE,
        UNAVAILABLE,
        CUSTOMMADE,
    }
}

