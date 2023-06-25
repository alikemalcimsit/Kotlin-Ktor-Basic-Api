package com.example.api.controller

import com.example.business.abstracts.IUserService
import com.example.dataaccess.abstracts.IUserDao
import com.example.dataaccess.concretes.UserDao
import com.example.entities.UserEntity

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database

class UserController(private val iUserService: IUserService) {

    fun Route.getAll () {
        get ("/user/getall"){
            call.respond(HttpStatusCode.OK,iUserService.getAll())
        }

    }

    fun Route.create(){
        post("/user/create") {
            val user = call.receive<UserEntity>()
            iUserService.create(user)
        }
    }


    fun Route.delete(){
        delete ("/user/delete/{id}" ){
            val id = call.parameters["id"]
            iUserService.delete(id!!.toInt())

        }
    }

}