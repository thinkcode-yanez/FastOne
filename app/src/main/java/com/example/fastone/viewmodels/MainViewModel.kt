package com.example.fastone.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fastone.models.Race
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
                        val newList = _rootRace.subList(race.round.toInt() - 1, 23)
                        _response.postValue(newList)
                        break
                    }
                    if (currentDate == race.date) {
                        Log.i("app", "Date1 is equal to Date2")
                        val newList = _rootRace.subList(race.round.toInt() - 1, 23)
                        _response.postValue(newList)
                        break
                    }
                }


            } else {
                Log.d("Test", "error al cargar datos")
            }
        }
    }


}
