package org.dronix.os.tool.domain

import assertk.assertions.isEqualTo
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.dronix.os.util.entitites.Ping
import org.junit.Test

class PingUseCaseTest{

    val command: PingCommand = mockk()
    val useCase = PingUseCase(command)

    @Test
    fun retrieveKernelData(){
        every { command.execute("8.8.8.8") } returns Ping( "8.8.8.8",64L, 1,119, 54.3f)

        val pingData =  runBlocking { useCase.ping("8.8.8.8") }

        assertk.assert(pingData.host).isEqualTo("8.8.8.8")
        assertk.assert(pingData.bytes).isEqualTo(64L)
        assertk.assert(pingData.icmpSeq).isEqualTo(1)
        assertk.assert(pingData.ttl).isEqualTo(119)
        assertk.assert(pingData.time).isEqualTo(54.3f)
    }
}