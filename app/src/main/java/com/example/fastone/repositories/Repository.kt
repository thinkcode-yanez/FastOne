package com.example.fastone.repositories

import com.example.fastone.api.ApiService
import javax.inject.Inject

class Repository
@Inject constructor(private val api:ApiService){


    suspend fun getAllRounds()=api.getAllRounds()

    suspend fun getLastResults()=api.getLastResults()

    suspend fun getDriverStandings()=api.getDriverStandings()

    suspend fun getConstructorsStandings()=api.getConstructorStandings()

    //HOLA TEST DE LO UE CAMBIE

}