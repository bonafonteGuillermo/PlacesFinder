package com.upsa.mimo.placesfinder.ui.favourites.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.model.Place
import kotlinx.android.synthetic.main.favourite_item.view.*
import kotlin.properties.Delegates

typealias Listener = (Place) -> Unit

class FavouritesAdapter(
    data: List<Place> = emptyList(),
    private var listener: Listener
) : RecyclerView.Adapter<FavouritesAdapter.FavouritesPlacesViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavouritesPlacesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.favourite_item, null), listener)

    override fun onBindViewHolder(holder: FavouritesPlacesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.count()

    class FavouritesPlacesViewHolder(view: View, private val listener: Listener) : RecyclerView.ViewHolder(view) {

        fun bind(placeItem: Place) = with(itemView) {
            tv_favourite_place_name.text = placeItem.name
            setOnClickListener { listener(placeItem) }
        }
    }
}