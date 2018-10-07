package org.dronix.os.util.entitites

data class Kernel(
    val name: String,
    val host: String,
    val version: String) {

    override fun toString(): String = "name: $name , host: $host version: $version"
}