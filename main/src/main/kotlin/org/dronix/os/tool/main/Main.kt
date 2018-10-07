package org.dronix.os.tool.main

import org.dronix.os.tool.domain.KernelInfoUseCase
import org.dronix.os.tool.kernelinfo.LinuxKernelRepository

suspend fun main(args: Array<String>) {

    val kernelRepository = LinuxKernelRepository()
    val kernelInfoUseCase = KernelInfoUseCase(kernelRepository)

    val kernelInfo = kernelInfoUseCase.getKernelInfo()
    println("name: ${kernelInfo.name} , host: ${kernelInfo.host} version: ${kernelInfo.version}")

}