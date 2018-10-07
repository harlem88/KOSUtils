package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.Kernel

class KernelInfoUseCase(
    private val kernelRepository: KernelRepository) {


    suspend fun getKernelInfo(): Kernel {

        val kernelInfo = kernelRepository.getInfo()

        return kernelInfo
    }
}