package org.dronix.os.tool.domain

import org.dronix.os.util.entitites.Kernel

interface KernelRepository{
    fun getInfo() : Kernel
}