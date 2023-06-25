package com.example

import com.example.core.dependencyInjection.controllerModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(controllerModule)
    }
    configureSecurity()
    configureSerialization()

    configureRouting()
    userRouting()
}
