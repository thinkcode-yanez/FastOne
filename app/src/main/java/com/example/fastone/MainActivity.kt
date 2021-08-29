package com.example.fastone

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fastone.adapters.RoundsAdapter
import com.example.fastone.databinding.ActivityMainBinding
import com.example.fastone.repositories.CircuitsRepository
import com.example.fastone.repositories.PilotsRepository
import com.example.fastone.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var roundsAdapter: RoundsAdapter
    private var PilotsRepository = PilotsRepository()


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

            binding.tvFirst.text =
                "#1 ${it[0].Driver.givenName} ${it[0].Driver.familyName}"
            val image1 = PilotsRepository.getPilot(it[0].Driver.driverId)
            Glide.with(this).load(image1).into(binding.ivFirst)
            binding.tvSecond.text =
                "#2 ${it[1].Driver.givenName} ${it[1].Driver.familyName}"
            val image2 = PilotsRepository.getPilot(it[1].Driver.driverId)
            Glide.with(this).load(image2).into(binding.ivSecond)
            binding.tvThird.text =
                "#3 ${it[2].Driver.givenName} ${it[2].Driver.familyName}"
            val image3 = PilotsRepository.getPilot(it[2].Driver.driverId)
            Glide.with(this).load(image3).into(binding.ivThird)

        })

        viewModel._responseDataCircuit.observe(this, {

            binding.tvCircuit.text="Circuit: ${it.Circuit.circuitName}"
            binding.tvRound.text="Round: ${it.round}"
            binding.tvDate.text="Date: ${it.date}"
        })


    }

}