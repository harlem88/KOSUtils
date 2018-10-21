package org.dronix.os.util.entitites

data class Location(
    val country: String,
    val region: String,
    val city: String,
    val latitude: Float,
    val longitude: Float,
    val postalCode: String,
    val timezone: String
)