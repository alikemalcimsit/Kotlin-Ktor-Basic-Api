package com.example.entities

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable
@Serializable
data  class UserEntity(val id:Int , val name:String , val email:String , val password :String)



object Users : IntIdTable(){

    val name = varchar("name" , 30)
    val email = text("email")
    val password = text("password")

}
