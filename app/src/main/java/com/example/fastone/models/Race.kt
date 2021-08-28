package com.example.fastone.models

data class Race(
    val Circuit: Circuit,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)