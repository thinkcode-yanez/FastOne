package com.example.fastone.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fastone.models.ConstructorStanding
import com.example.fastone.models.DriverStanding
import com.example.fastone.models.DriverStandings
import com.example.fastone.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel
@Inject constructor(private val repo:Repository):ViewModel() {

    val _responseDriver=MutableLiveData<List<DriverStanding>>()
    val _responseConstructor=MutableLiveData<List<ConstructorStanding>>()


    fun getDriverStandings() = viewModelScope.launch {

        repo.getDriverStandings().let {
            val data=it.body()
            if(it.isSuccessful){

              val _rootDriver= data!!.MRData.StandingsTable.StandingsLists.get(0).DriverStandings
                _responseDriver.postValue(_rootDriver)

                for(driver in _rootDriver){
                    Log.d("Lista", driver.Driver.familyName)
                }

            }
        }
    }

    fun getConstructorStanding()=viewModelScope.launch {
        repo.getConstructorsStandings().let {
            val data=it.body()
            if(it.isSuccessful){
                val _rootConstructor=data!!.MRData.StandingsTable.StandingsLists.get(0).ConstructorStandings

                _responseConstructor.postValue(_rootConstructor)
            }
        }
    }


}