package com.delivery.firstkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform