package org.dronix.os.tool.main

import org.dronix.os.tool.domain.GeoIpUseCase
import org.dronix.os.tool.domain.KernelInfoUseCase
import org.dronix.os.tool.domain.PingUseCase
import org.dronix.os.tool.kernelinfo.LinuxKernelRepository
import org.dronix.os.tool.ping.LinuxPingCommand
import org.dronix.os.util.geoipapi.IPifyGeoIPRepository

suspend fun main(args: Array<String>) {
    if (args.isNotEmpty()) {

        when (args[0]) {
            "public_ip" -> {
                getMyPublicIP()
            }
            "location" -> {
                if (args.size > 1) getMyLocation(args[1])
            }
            else -> {
                getKernel()
            }
        }
    }
}

suspend fun getMyPublicIP() {
    val geoIpRepository = IPifyGeoIPRepository("")
    val geoIpUseCase = GeoIpUseCase(geoIpRepository)

    val ip = geoIpUseCase.getPublicIP()
    println(ip.toString())
}

suspend fun getMyLocation(apiKey: String) {
    val geoIpRepository = IPifyGeoIPRepository(apiKey)
    val geoIpUseCase = GeoIpUseCase(geoIpRepository)

    val geoIp = geoIpUseCase.getLocation()
    println(geoIp.toString())
}

suspend fun getKernel() {
    val kernelRepository = LinuxKernelRepository()
    val kernelInfoUseCase = KernelInfoUseCase(kernelRepository)

    val kernelInfo = kernelInfoUseCase.getKernelInfo()
    println(kernelInfo.toString())
}

suspend fun pingCommand() {
    val pingCommand = LinuxPingCommand()
    val pingCommandUsecase = PingUseCase(pingCommand)
    println("START PING")
    val pingData = pingCommandUsecase.ping("8.8.8.8")
    println(pingData.toString())
}

