package org.dronix.os.tool.ping


import kotlinx.coroutines.*
import org.dronix.os.tool.domain.PingCommand
import org.dronix.os.util.entitites.Ping
import java.io.BufferedReader
import java.io.InputStreamReader


class LinuxPingCommand : PingCommand{

    override fun execute(host: String): Ping {
        val pingOut =  runBlocking{ exec(host) }
        return parsePingData(pingOut)
    }

    suspend fun exec(host: String) : String{
        var out = ""

        val job = GlobalScope.launch {
            val p = Runtime.getRuntime().exec("ping $host")
            val inputStream = BufferedReader(
                InputStreamReader(p.inputStream)
            )

            var s = inputStream.readLine()

            while (s != null && isActive) {
                out += s + "\n"
                s = inputStream.readLine()
            }
            p.destroy()
        }

        delay(15000)
        job.cancelAndJoin()
        return out
    }

    fun parsePingData(out: String):Ping{
        val pings = out.trim().split("\n")
        val lastPing = pings[pings.size - 1]
        val pingValue = lastPing.split(" ")
        return Ping(pingValue[3].replace(":", "")
            , pingValue[0].toLong()
            , pingValue[4].split("icmp_seq=")[1].trim().toInt()
            , pingValue[5].split("ttl=")[1].trim().toInt()
            , pingValue[6].split("time=")[1].trim().toFloat())

    }
}