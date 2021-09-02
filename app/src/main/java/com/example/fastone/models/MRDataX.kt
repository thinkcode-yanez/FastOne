package com.example.fastone.models

data class MRDataX(
    val RaceTable: RaceTableX,
    val limit: String,
    val offset: String,
    val series: String,
    val total: String,
    val url: String,
    val xmlns: String
)