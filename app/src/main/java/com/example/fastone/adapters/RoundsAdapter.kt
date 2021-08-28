package com.example.fastone.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fastone.R
import com.example.fastone.databinding.ItemRaceBinding
import com.example.fastone.models.Race
import java.text.SimpleDateFormat
import java.util.*


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


            binding.tvRaceName.text = item.raceName
            binding.tvRound.text = item.round

        }


    }


}