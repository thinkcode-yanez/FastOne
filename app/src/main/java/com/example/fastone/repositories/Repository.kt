package com.example.fastone.repositories

import com.example.fastone.api.ApiService
import javax.inject.Inject

class Repository
@Inject constructor(private val api:ApiService){


    suspend fun getAllRounds()=api.getAllRounds()

}