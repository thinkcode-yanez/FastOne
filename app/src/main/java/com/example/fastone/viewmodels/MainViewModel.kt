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

    //  val _response=MutableLiveData<Boolean>()
    // var _rootRace= listOf<Race>()

    val _response = MutableLiveData<List<Race>>()

    val responseShow: LiveData<List<Race>>
        get() = _response

    init {
        // getAllRounds()
    }


    fun getAllRounds() = viewModelScope.launch {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentDate = current.format(formatter)

        repo.getAllRounds().let { response ->
            val data = response.body()
            if (response.isSuccessful) {
                //_response.postValue(it.body())
                //  _response.value=true
                val races = data!!.MRData.total.toInt()//TOTAL DE CARRERAS
               // val race =0
                val _rootRace = data.MRData.RaceTable.Races
                Log.d("Test", "Total de carreras ${_rootRace.size}")
                Log.d("Test", "Total de races $races")



                for(race in _rootRace){

                    if (currentDate > race.date) {
                        Log.i("app", "Date1 is after Date2")
                    }
                        if (currentDate < race.date) {
                        Log.i("app", "Date1 is before Date2")
                        val newList=_rootRace.subList(race.round.toInt()-1,23)
                        _response.postValue(newList)
                            break
                    }
                        if (currentDate==race.date) {
                        Log.i("app", "Date1 is equal to Date2")
                        val newList=_rootRace.subList(race.round.toInt()-1,23)
                        _response.postValue(newList)
                            break
                    }
                }

              /*  while (race < races) {//1 <= 23

                    if(_rootRace[race].date == formatted){
                        Log.d("Fecha","Hoy es la fecha de carrera ${_rootRace.get(race).date}")
                        val newList=_rootRace.subList(race,races)
                        _response.postValue(newList)
                       // break
                    }
                    Log.d("test1", "${_rootRace.get(race).raceName}")
                    Log.d("test1", "${_rootRace.get(race).date}")
                    race++
                }*/

            } else {
                Log.d("Test", "error al cargar datos")
            }
        }
    }

    fun pendingRounds(_rootRace: List<Race>) {

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter)






    }


}