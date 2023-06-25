package com.example.business.abstracts

import com.example.entities.UserEntity

interface IUserService {

    fun getAll():List<UserEntity>
    fun create(userEntity: UserEntity)
    fun delete(id:Int)
}