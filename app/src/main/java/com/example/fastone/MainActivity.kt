package com.example.fastone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fastone.adapters.RoundsAdapter
import com.example.fastone.databinding.ActivityMainBinding
import com.example.fastone.repositories.PilotsRepository
import com.example.fastone.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


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
            val circuit=it.Circuit.circuitName
            val round=it.round
            binding.tvData.text="Last Round ${round} - ${circuit} Winners"
        })

        binding.btnStandings.setOnClickListener {
            val intent= Intent(this,DriverStandings::class.java)
            startActivity(intent)
        }


    }

}