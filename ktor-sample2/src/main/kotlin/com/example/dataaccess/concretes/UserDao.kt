package com.example.dataaccess.concretes

import com.example.core.dataacces.ConnectDb
import com.example.dataaccess.abstracts.IUserDao
import com.example.entities.UserEntity
import com.example.entities.Users

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class UserDao(private val table: Users) : IUserDao ,ConnectDb<Users>(table) {





    override fun getAll(): List<UserEntity> {
        return transaction {
            table.selectAll().map { resultRow ->
                UserEntity(
                    id = resultRow[Users.id].value,
                    name = resultRow[Users.name],
                    email = resultRow[Users.email],
                    password = resultRow[Users.password]
                )
            }
        }
    }

    override fun create(userEntity: UserEntity) {
        transaction {
            table.insert {
                it[name] = userEntity.name
                it[email] = userEntity.email
                it[password] = userEntity.password
            }
        }
    }

    override fun delete(id: Int) {
        transaction {
            table.deleteWhere { Users.id.eq(id) }
        }


    }
}