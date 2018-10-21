package org.dronix.os.util.geoipapi

import java.net.URL
import java.util.*

private const val API_URL_IP = "https://api.ipify.org?format=json"
private const val API_URL = "https://geo.ipify.org/api/v1?"

object IPfyRequestHandler {

    fun getIp(): String {
        return get(API_URL_IP)
    }

    fun getGeoIp(apiKey: String, ip: String): String{
        return get("$API_URL&apiKey=$apiKey&ipAddress=$ip")
    }

    private fun get(url: String): String {
        var result = ""
        try {
            Scanner(URL(url).openStream())
                .use { s -> result += s.useDelimiter("\\A").next() }
            println("IPfyRequestHandler: GET $result")
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return result
    }
}