package org.dronix.os.util.geoipapi.model

import kotlinx.serialization.Serializable

@Serializable
data class GeoIPModel(val ip: String, val location: LocationModel)