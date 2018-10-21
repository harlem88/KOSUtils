package org.dronix.os.util.entitites

data class IP(val address: String){
    override fun toString(): String {
        return "Address: $address"
    }
}