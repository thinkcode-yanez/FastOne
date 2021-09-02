package com.example.fastone

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.format.DateUtils
import android.text.format.DateUtils.*
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fastone.adapters.RoundsAdapter
import com.example.fastone.databinding.ActivityMainBinding
import com.example.fastone.repositories.PilotsRepository
import com.example.fastone.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var roundsAdapter: RoundsAdapter
    private var PilotsRepository = PilotsRepository()
    lateinit var  countDownTimer:CountDownTimer


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getAllRounds()
        viewModel.getLastResults()




        binding.rvMain.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel._response.observe(this, {

            roundsAdapter = RoundsAdapter(it)

            binding.rvMain.adapter = roundsAdapter

        })

        viewModel._responseWinners.observe(this, {
            //Datos de los ganadores
            binding.tvFirst.text =
                "#1 ${it[0].Driver.familyName}"
            val image1 = PilotsRepository.getPilot(it[0].Driver.driverId)
            Glide.with(this).load(image1).into(binding.ivFirst)
            binding.tvSecond.text =
                "#2 ${it[1].Driver.familyName}"
            val image2 = PilotsRepository.getPilot(it[1].Driver.driverId)
            Glide.with(this).load(image2).into(binding.ivSecond)
            binding.tvThird.text =
                "#3 ${it[2].Driver.familyName}"
            val image3 = PilotsRepository.getPilot(it[2].Driver.driverId)
            Glide.with(this).load(image3).into(binding.ivThird)

        })

        viewModel._responseDataCircuit.observe(this, {
            //Datos extras de la ultima carrera competida
            val circuit = it.Circuit.circuitName
            val round = it.round
            binding.tvData.text = "Last Round ${round} - ${circuit} Winners"
        })

        viewModel._responseDate.observe(this,{
            val starDate=Calendar.getInstance() //Fecha Actual
            val endDate=Calendar.getInstance() //Instanciamos la fecha de proxima carrera
            val date = it
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH)
            val localDate = LocalDateTime.parse(date, formatter)//Convertimos el string en fecha

            endDate.set(localDate.year,localDate.monthValue-1,localDate.dayOfMonth,0,0)//Seteamos la fecha
            val starDateInMillis=starDate.timeInMillis //Get date start in millis // get date end in millis
            val endDateInMillis=endDate.timeInMillis

            val totalMillis=endDateInMillis-starDateInMillis

            //CONTADOR HASTA LA SIGUIENTE CARRERA
            object : CountDownTimer(totalMillis,1000) {
                val time = StringBuilder();
                override fun onFinish() {
                    binding.tvContador.setText("Its Race Day!!")
                }

                override fun onTick(millisUntilFinished: Long) {
                    var millisUntilFinished = millisUntilFinished
                    time.setLength(0)
                    if (millisUntilFinished > DAY_IN_MILLIS) {
                        val count = millisUntilFinished / DAY_IN_MILLIS
                        if (count > 1) time.append(count).append(" days ") else time.append(count)
                            .append(" day ")
                        millisUntilFinished %= DAY_IN_MILLIS
                    }

                    time.append(formatElapsedTime(Math.round(millisUntilFinished / 1000.0)))
                    binding.tvContador.setText(time.toString())
                }
            }.start()


        })

        binding.btnStandings.setOnClickListener {
            val intent = Intent(this, DriverStandings::class.java)
            startActivity(intent)
        }


    }

}