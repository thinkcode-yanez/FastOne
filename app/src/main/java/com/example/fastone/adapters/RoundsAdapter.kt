package com.example.fastone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastone.R
import com.example.fastone.databinding.ItemRaceBinding
import com.example.fastone.models.Race
import com.example.fastone.repositories.CircuitsRepository


class RoundsAdapter(private val dataSet: List<Race>?) :
    RecyclerView.Adapter<RoundsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_race, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


        val item = dataSet?.get(position)
        viewHolder.enlazarItem(item!!)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemRaceBinding.bind(view)
        var context = view.context
        //    var mainRepository = MainRepository()


        fun enlazarItem(item: Race) {
            val circuit=CircuitsRepository()
            when(item.Circuit.circuitId) {
                "bahrain"->Glide.with(context).load(circuit.bahrain).into(binding.ivCircuit)
                "imola"->Glide.with(context).load(circuit.imola).into(binding.ivCircuit)
                "portimao"->Glide.with(context).load(circuit.portimao).into(binding.ivCircuit)
                "catalunya"->Glide.with(context).load(circuit.catalunya).into(binding.ivCircuit)
                "monaco"->Glide.with(context).load(circuit.monaco).into(binding.ivCircuit)
                "BAK"->Glide.with(context).load(circuit.bak).into(binding.ivCircuit)
                "ricard"->Glide.with(context).load(circuit.rikad).into(binding.ivCircuit)
                "red_bull_ring"->Glide.with(context).load(circuit.styrianredbullring).into(binding.ivCircuit)
                "silverstone"->Glide.with(context).load(circuit.silverston).into(binding.ivCircuit)
                "hungaroring"->Glide.with(context).load(circuit.hungaroring).into(binding.ivCircuit)
                "spa"-> Glide.with(context).load(circuit.spa).into(binding.ivCircuit)
                "americas"->Glide.with(context).load(circuit.usa).into(binding.ivCircuit)
                "zandvoort"->Glide.with(context).load(circuit.holanda).into(binding.ivCircuit)
                "monza"->Glide.with(context).load(circuit.imola).into(binding.ivCircuit)
                "sochi"->Glide.with(context).load(circuit.sochi).into(binding.ivCircuit)
                "istanbul"->Glide.with(context).load(circuit.istanbul).into(binding.ivCircuit)
                "suzuka"->Glide.with(context).load(circuit.susuka).into(binding.ivCircuit)
                "rodriguez"->Glide.with(context).load(circuit.mexico).into(binding.ivCircuit)
                "interlagos"->Glide.with(context).load(circuit.interlagos).into(binding.ivCircuit)
                "albert_park"->Glide.with(context).load(circuit.australia).into(binding.ivCircuit)
                "jeddah"->Glide.with(context).load(circuit.saudiarabia).into(binding.ivCircuit)
                "yas_marina"->Glide.with(context).load(circuit.yasmarina).into(binding.ivCircuit)
                else-> Glide.with(context).load("null").into(binding.ivCircuit)
            }

            binding.tvRaceName.text = item.raceName
            binding.tvRound.text = item.round

        }


    }




}