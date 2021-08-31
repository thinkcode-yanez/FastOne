package com.example.fastone

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastone.adapters.ConstructorAdapter
import com.example.fastone.adapters.DriversAdapter
import com.example.fastone.databinding.ConstructorStandingsBinding
import com.example.fastone.viewmodels.StandingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConstructorStandings : AppCompatActivity() {

    lateinit var binding:ConstructorStandingsBinding
    private val viewModel:StandingsViewModel by viewModels()
    lateinit var constructorAdapter: ConstructorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ConstructorStandingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getConstructorStanding()


        binding.rvConstructors.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
        viewModel._responseConstructor.observe(this, {

            constructorAdapter= ConstructorAdapter(it)
            binding.rvConstructors.adapter = constructorAdapter

        })




        binding.btnDriverStand.setOnClickListener {
            finish()

        }
    }
}