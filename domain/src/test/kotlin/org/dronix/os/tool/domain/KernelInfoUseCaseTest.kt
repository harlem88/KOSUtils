package org.dronix.os.tool.domain

import io.mockk.mockk
import org.dronix.os.util.entitites.Kernel
import org.junit.Test
import io.mockk.every
import kotlinx.coroutines.runBlocking
import assertk.assert
import assertk.assertions.isEqualTo


class KernelInfoUseCaseTest{

    val repository: KernelRepository = mockk()
    val useCase = KernelInfoUseCase(repository)

    @Test
    fun retrieveKernelData(){
        every { repository.getInfo() } returns Kernel( "Linux","x-host", "4.15.123")

        val kernelData =  runBlocking { useCase.getKernelInfo() }

        assert(kernelData.name).isEqualTo("Linux")
        assert(kernelData.host).isEqualTo("x-host")
        assert(kernelData.version).isEqualTo("4.15.123")

    }

}