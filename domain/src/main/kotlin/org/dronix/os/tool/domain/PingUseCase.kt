package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.Ping

class PingUseCase(
        private val pingCommand: PingCommand){


    suspend fun ping(host: String) : Ping{
        val pingData = pingCommand.execute(host)
        return pingData
    }
}