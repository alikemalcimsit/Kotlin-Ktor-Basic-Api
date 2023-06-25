package com.example.dataaccess.abstracts

import com.example.entities.UserEntity

interface IUserDao {

    fun getAll():List<UserEntity>
    fun create(userEntity: UserEntity)
    fun delete(id:Int)

}