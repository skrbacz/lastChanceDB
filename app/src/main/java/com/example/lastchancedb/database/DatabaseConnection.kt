package com.example.lastchancedb.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


/**
 * Provides a connection to the database using JDBC.
 */
object DatabaseConnection {

    private const val URL= "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11702015?useUnicode=true&characterEncoding=utf-8&serverTimezone=CET" //jdbc:mysql://localhost:3306/lastChanceDB?useUnicode=true&characterEncoding=utf-8&serverTimezone=CET
    private const val USER = "sql11702015"
    private const val PASS= "TnlplQPiEN"

    init{
        Class.forName("com.mysql.jdbc.Driver")
    }

    /**
     * Retrieves a database connection.
     *
     * @return A Connection object representing the database connection.
     * @throws RuntimeException if an error occurs while connecting to the database.
     */
    fun getConnection(): Connection{
        try{
            return DriverManager.getConnection(URL,USER,PASS)
        } catch (ex: SQLException) {
            throw RuntimeException("Error connecting to the database", ex)
        }
    }

    /**
     * Entry point of the application.
     *
     * @param args Command-line arguments.
     */
    @JvmStatic
    fun main(args: Array<String>){
        try{
            val conn = getConnection()
            conn.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

}