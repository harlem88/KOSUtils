package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.Ping

interface PingCommand {
    fun execute(host: String) : Ping
}