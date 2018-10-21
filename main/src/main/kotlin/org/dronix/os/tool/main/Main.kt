package org.dronix.os.tool.main

import org.dronix.os.tool.domain.GeoIpUseCase
import org.dronix.os.tool.domain.KernelInfoUseCase
import org.dronix.os.tool.domain.PingUseCase
import org.dronix.os.tool.kernelinfo.LinuxKernelRepository
import org.dronix.os.tool.ping.LinuxPingCommand
import org.dronix.os.util.geoipapi.IPifyGeoIPRepository

suspend fun main(args: Array<String>) {


getMyPublicIP()

}

suspend fun getMyPublicIP(){
    val geoIpRepository = IPifyGeoIPRepository("")
    val geoIpUseCase = GeoIpUseCase(geoIpRepository)

    val ip = geoIpUseCase.getPublicIP()
    println(ip.toString())
}


suspend fun getKernel(){
    val kernelRepository = LinuxKernelRepository()
    val kernelInfoUseCase = KernelInfoUseCase(kernelRepository)

    val kernelInfo = kernelInfoUseCase.getKernelInfo()
    println(kernelInfo.toString())
}

suspend fun pingCommand(){
    val pingCommand = LinuxPingCommand()
    val pingCommandUsecase = PingUseCase(pingCommand)
    println("START PING")
    val pingData = pingCommandUsecase.ping("8.8.8.8")
    println(pingData.toString())
}

