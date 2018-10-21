package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.GeoIp
import org.dronix.os.util.entitites.IP

interface GeoIpRepository {

    fun getPublicIp(): IP?
    fun getGeoIP(): GeoIp?

}