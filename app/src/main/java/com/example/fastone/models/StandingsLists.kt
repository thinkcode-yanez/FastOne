package com.example.fastone.models

data class StandingsLists(
    val DriverStandings: List<DriverStanding>,
    val round: String,
    val season: String
)