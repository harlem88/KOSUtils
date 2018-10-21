package org.dronix.os.util.entitites

data class GeoIp(val ip: IP, val location: Location) {
    override fun toString(): String {
        return "$ip, Location{ city: ${location.city}, country: ${location.country}, lat: ${location.latitude}, lng: ${location.longitude}, region: ${location.region} postal code: ${location.postalCode}, timezone: ${location.timezone}  }"
    }
}