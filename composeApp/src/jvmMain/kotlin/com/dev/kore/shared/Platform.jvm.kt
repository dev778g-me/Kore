package com.dev.kore

import com.dev.kore.shared.Platform

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

