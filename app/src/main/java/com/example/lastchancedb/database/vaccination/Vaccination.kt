package com.example.lastchancedb.database.vaccination

data class Vaccination(
    val name:String?=null,
//    val producer: String?= null,
    val daysUntilNextDose: Int?= null,
    val manufacturer:String?=null
)
