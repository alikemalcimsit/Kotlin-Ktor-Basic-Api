package com.example.core.dependencyInjection

import com.example.api.controller.UserController
import com.example.business.abstracts.IUserService
import com.example.business.concretes.UserService
import com.example.dataaccess.abstracts.IUserDao
import com.example.dataaccess.concretes.UserDao
import com.example.entities.Users

import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module

val controllerModule= module{

        single<IUserService> { UserService(UserDao(Users)) }
        single { UserController(get()) }


}
