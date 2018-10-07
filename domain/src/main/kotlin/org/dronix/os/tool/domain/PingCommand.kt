package org.dronix.os.tool.domain

interface PingCommand {
    fun execute(host: String)
}