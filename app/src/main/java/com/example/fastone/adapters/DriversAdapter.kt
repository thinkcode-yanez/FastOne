package com.example.fastone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastone.R
import com.example.fastone.databinding.ActivityMainBinding.bind
import com.example.fastone.databinding.DriverStandingsBinding
import com.example.fastone.databinding.ItemDriverBinding
import com.example.fastone.databinding.ItemRaceBinding
import com.example.fastone.models.DriverStanding
import com.example.fastone.models.Race
import com.example.fastone.repositories.CircuitsRepository


class DriversAdapter(private val dataSet: List<DriverStanding>?) :
    RecyclerView.Adapter<DriversAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_driver, viewGroup, false)

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
        var binding= ItemDriverBinding.bind(view)
        var context = view.context
        //    var mainRepository = MainRepository()


        fun enlazarItem(item: DriverStanding) {
            val circuit= CircuitsRepository()

            val name="${item.Driver.givenName} ${item.Driver.familyName}"

            binding.tvName.text=name
            binding.tvPosition.text=item.position
            binding.tvPoints.text=item.points


        }


    }




}