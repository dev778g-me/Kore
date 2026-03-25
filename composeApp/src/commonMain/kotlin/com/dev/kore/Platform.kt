package com.dev.kore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform