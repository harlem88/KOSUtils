package org.dronix.os.util.geoipapi.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationModel(
    val country: String,
    val region: String,
    val city: String,
    val lat: Float,
    val lng: Float,
    val postalCode: String,
    val timezone: String
)