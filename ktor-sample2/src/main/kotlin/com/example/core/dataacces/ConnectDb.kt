package com.example.core.dataacces

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction


open class ConnectDb<T:Table>(private val table : T) {
    init {
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/ali",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "1462"
        )
        createTable()
    }

    private fun createTable(){
        transaction {
            SchemaUtils.create(table)
        }
    }}