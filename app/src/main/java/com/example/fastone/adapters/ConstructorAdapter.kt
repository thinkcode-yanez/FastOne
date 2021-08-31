package com.example.fastone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fastone.R
import com.example.fastone.databinding.ItemConstructorBinding
import com.example.fastone.databinding.ItemDriverBinding
import com.example.fastone.models.ConstructorStanding
import com.example.fastone.models.DriverStanding
import com.example.fastone.repositories.CircuitsRepository
import com.example.fastone.repositories.TeamsRepository


class ConstructorAdapter(private val dataSet: List<ConstructorStanding>?) :
    RecyclerView.Adapter<ConstructorAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_constructor, viewGroup, false)

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
        var binding= ItemConstructorBinding.bind(view)
        var context = view.context
       // val team=TeamsRepository()
        //    var mainRepository = MainRepository()


        fun enlazarItem(item: ConstructorStanding) {
            val team=TeamsRepository()
            val logo=team.getTeamLogo(item.Constructor.constructorId)
           // val name="${item.Driver.givenName} ${item.Driver.familyName}"
           Glide.with(context).load(logo).into(binding.ivLogo)
            binding.tvName.text=item.Constructor.name
            binding.tvPosition.text=item.position
            binding.tvPoints.text=item.points


        }


    }




}