package org.dronix.os.tool.kernelinfo

import org.dronix.os.tool.domain.KernelRepository
import org.dronix.os.util.entitites.Kernel

class LinuxKernelRepository: KernelRepository{
    override fun getInfo(): Kernel {

        val p = ProcessBuilder("uname", "-a")
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .start()

        val unameOut = p.inputStream.bufferedReader().readText()
        return parseUname(unameOut)
    }


    private fun parseUname(outComamnd: String): Kernel{
        val values  = outComamnd.split(" ")
        val kernelInfo = Kernel(values[0], values[1], values[2])
        return kernelInfo
    }
}