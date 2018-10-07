package org.dronix.os.util.entitites

data class Ping(
        val host: String,
        val bytes: Long,
        val icmpSeq : Int,
        val ttl : Int,
        val time : Float)