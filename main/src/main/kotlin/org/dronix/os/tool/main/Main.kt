package org.dronix.os.tool.main

import org.dronix.os.tool.domain.KernelInfoUseCase
import org.dronix.os.tool.domain.PingUseCase
import org.dronix.os.tool.kernelinfo.LinuxKernelRepository
import org.dronix.os.tool.ping.LinuxPingCommand

suspend fun main(args: Array<String>) {

    val kernelRepository = LinuxKernelRepository()
    val kernelInfoUseCase = KernelInfoUseCase(kernelRepository)

    val kernelInfo = kernelInfoUseCase.getKernelInfo()
    println(kernelInfo.toString())

    val pingCommand = LinuxPingCommand()
    val pingCommandUsecase = PingUseCase(pingCommand)
    println("START PING")
    val pingData = pingCommandUsecase.ping("8.8.8.8")
    println(pingData.toString())
}