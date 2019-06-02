package com.upsa.mimo.placesfinder.ui.places.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.model.Place
import kotlinx.android.synthetic.main.place_item.view.*
import kotlin.properties.Delegates

typealias Listener = (Place) -> Unit

class PlacesAdapter(
    data: List<Place> = emptyList(),
    private var listener: Listener
) : RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlacesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.place_item,null), listener)

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.count()

    class PlacesViewHolder(view: View, private val listener: Listener) : RecyclerView.ViewHolder(view) {

        fun bind(placeItem : Place) = with(itemView){
            tv_place_name.text = placeItem.name
            setOnClickListener { listener(placeItem) }
        }
    }
}