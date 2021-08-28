package com.example.fastone.api

import com.example.fastone.helper.Constants
import com.example.fastone.models.MRData
import com.example.fastone.models.RaceTable
import com.example.fastone.models.Rounds
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT_ROUNDS)
    suspend fun getAllRounds():Response<Rounds>
}