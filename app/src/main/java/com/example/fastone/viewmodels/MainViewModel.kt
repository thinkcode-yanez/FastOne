package com.example.fastone.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fastone.models.Race
import com.example.fastone.models.RaceX
import com.example.fastone.models.Result
import com.example.fastone.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repo: Repository) : ViewModel() {


    val _response = MutableLiveData<List<Race>>()
    val _responseWinners=MutableLiveData<List<Result>>()
    val _responseDataCircuit=MutableLiveData<RaceX>()
    val _responseDate=MutableLiveData<String>()


    fun getAllRounds() = viewModelScope.launch {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentDate = current.format(formatter)

        repo.getAllRounds().let { response ->
            val data = response.body()
            if (response.isSuccessful) {

                val races = data!!.MRData.total.toInt()//TOTAL DE CARRERAS
                val _rootRace = data.MRData.RaceTable.Races
                Log.d("Test", "Total de carreras ${_rootRace.size}")
                Log.d("Test", "Total de races $races")


               // _rootRace[0].Circuit.circuitId
              //  _response.postValue(_rootRace)

                for (race in _rootRace) {

                    if (currentDate > race.date) {
                        Log.i("app", "Date1 is after Date2")
                    }
                    if (currentDate < race.date) {
                        Log.i("app", "Date1 is before Date2")
                        val newList = _rootRace.subList(race.round.toInt() - 1, races)
                        _response.postValue(newList)
                        _responseDate.postValue("${race.date}")//agregar 00:00
                        break
                    }
                    if (currentDate == race.date) {
                        Log.i("app", "Date1 is equal to Date2")
                        val newList = _rootRace.subList(race.round.toInt() - 1, 23)
                        _response.postValue(newList)
                        _responseDate.postValue("${race.date}")
                        break
                    }
                }


            } else {
                Log.d("Test", "error al cargar datos")
            }
        }
    }

    fun getLastResults()= viewModelScope.launch {


        repo.getLastResults().let {

            val data=it.body()

            if(it.isSuccessful){
                val _rootLastResults=data!!.MRData.RaceTable.Races[0]

                Log.d("Results","First Place ${_rootLastResults.Results[0].Driver.givenName} " +
                        _rootLastResults.Results[0].Driver.familyName
                )
                Log.d("Results","Second Place ${_rootLastResults.Results[1].Driver.givenName} " +
                        _rootLastResults.Results[1].Driver.familyName
                )
                Log.d("Results","Third Place ${_rootLastResults.Results[2].Driver.givenName} " +
                        _rootLastResults.Results[2].Driver.familyName
                )
                _responseWinners.postValue(_rootLastResults.Results)//Guardamos la lista de ganadores
                _responseDataCircuit.postValue(_rootLastResults)

            }
        }
    }




}
