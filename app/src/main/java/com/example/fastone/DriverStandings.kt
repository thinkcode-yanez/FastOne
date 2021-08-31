package com.example.fastone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastone.adapters.DriversAdapter
import com.example.fastone.adapters.RoundsAdapter
import com.example.fastone.databinding.DriverStandingsBinding
import com.example.fastone.viewmodels.MainViewModel
import com.example.fastone.viewmodels.StandingsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DriverStandings : AppCompatActivity() {

    lateinit var binding: DriverStandingsBinding
    private val viewModel:StandingsViewModel by viewModels()
    lateinit var driversAdapter: DriversAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DriverStandingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getDriverStandings()



        binding.rvDrivers.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
        viewModel._responseDriver.observe(this, {

            driversAdapter=DriversAdapter(it)

            binding.rvDrivers.adapter = driversAdapter

        })

        binding.btnConstructor.setOnClickListener {
            val intent=Intent(this,ConstructorStandings::class.java)
            startActivity(intent)
        }




    }
}