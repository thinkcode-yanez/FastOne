package com.example.fastone.models

data class DriverStanding(
    val Constructors: List<ConstructorX>,
    val Driver: DriverX,
    val points: String,
    val position: String,
    val positionText: String,
    val wins: String
)