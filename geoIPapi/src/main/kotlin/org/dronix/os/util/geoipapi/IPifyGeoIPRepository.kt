package org.dronix.os.util.geoipapi

import org.dronix.os.tool.domain.GeoIpRepository
import org.dronix.os.util.entitites.GeoIp
import kotlinx.serialization.json.JSON
import org.dronix.os.util.entitites.IP
import org.dronix.os.util.entitites.Location
import org.dronix.os.util.geoipapi.model.GeoIPModel
import org.dronix.os.util.geoipapi.model.IPModel

class IPifyGeoIPRepository(private val apiKey: String) : GeoIpRepository {
    override fun getPublicIp(): IP? {
        var ip: IP? = null
        val result = IPfyRequestHandler.getIp()
        if (result.isNotEmpty()) {
            try {
                val obj  = JSON.parse(IPModel.serializer(), result)
                ip = IP(obj.ip)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return ip
    }

    override fun getGeoIP(): GeoIp? {
        var geoIP: GeoIp? = null
        val result = IPfyRequestHandler.getGeoIp(apiKey, "8.8.8.8")
        if (result.isNotEmpty()) {
            try {
                val obj = JSON.parse<GeoIPModel>(result)
                geoIP = geoIPModelToGeoIP(obj)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return geoIP
    }

    private fun geoIPModelToGeoIP(geoIp: GeoIPModel) : GeoIp{
        return GeoIp(
            IP(geoIp.ip),
            Location(
                geoIp.location.country,
                geoIp.location.region,
                geoIp.location.city,
                geoIp.location.lat,
                geoIp.location.lng,
                geoIp.location.postalCode,
                geoIp.location.timezone
            ))
    }
}