package com.example.plugins

import com.example.api.controller.UserController
import com.example.business.abstracts.IUserService
import com.example.dataaccess.abstracts.IUserDao
import com.example.dataaccess.concretes.UserDao
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.h2.engine.Database
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }


}



fun Application.userRouting(){
val userController: UserController by inject()
routing {
    userController.apply {
        getAll()
        create()
        delete()
    }
}
}
