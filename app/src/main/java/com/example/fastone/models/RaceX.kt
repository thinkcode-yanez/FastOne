package com.example.fastone.models

data class RaceX(
    val Circuit: CircuitX,
    val Results: List<Result>,
    val date: String,
    val raceName: String,
    val round: String,
    val season: String,
    val time: String,
    val url: String
)