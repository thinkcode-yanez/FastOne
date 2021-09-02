package com.example.fastone.api

import com.example.fastone.ConstructorStandings
import com.example.fastone.helper.Constants
import com.example.fastone.models.*
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT_ROUNDS)
    suspend fun getAllRounds():Response<Rounds>

    @GET(Constants.END_POINT_LAST_RESULTS)
    suspend fun getLastResults():Response<Results>

    @GET(Constants.END_POINT_LAST_DRIVER_STANDINGS)
    suspend fun getDriverStandings():Response<DriverStandings>

    @GET(Constants.END_POINT_LAST_CONSTRUCTOR_STANDINGS)
    suspend fun getConstructorStandings():Response<ConstructorsStandings>



}