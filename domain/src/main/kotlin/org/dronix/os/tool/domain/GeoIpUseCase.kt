package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.GeoIp
import org.dronix.os.util.entitites.IP

class GeoIpUseCase(
    private val geoIp: GeoIpRepository) {

    suspend fun getPublicIP(): IP? {
        val ip = geoIp.getPublicIp()
        return ip
    }

    suspend fun getGeoIP(): GeoIp? {
        val geoIP = geoIp.getGeoIP()
        return geoIP
    }
}