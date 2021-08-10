package com.aliahmed.sondertechnicaltest.adapter

import android.R
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aliahmed.sondertechnicaltest.databinding.ItemPassengerListBinding
import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.utils.ItemClickListener
import com.aliahmed.sondertechnicaltest.utils.loadImage
import com.bumptech.glide.Glide


class PassengersAdapter(private val itemClickListener: ItemClickListener) :
    PagingDataAdapter<Passenger, PassengersAdapter.PassengersViewHolder>(PassengersComparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PassengersViewHolder {
        return PassengersViewHolder(
            ItemPassengerListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: PassengersViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindPassenger(it) }
        holder.itemView.setOnClickListener {
            itemClickListener.itemClick(position)
        }
    }

    inner class PassengersViewHolder(private val binding: ItemPassengerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindPassenger(item: Passenger) = with(binding) {
            imgLogo.loadImage(item.airline[0].logo)
            txtCountyName.text = item.airline[0].country
            txtTrips.text = " ${item.trips} Trips"
            txtFlightName.text = item.airline[0].name.trim()
            txtPassengerName.text = item.name
            Glide.with(imgLogo).load(item.airline[0].logo)

            imgLogo.setOnClickListener {
                itemClickListener.itemClick(item)
            }
        }
    }

    object PassengersComparator : DiffUtil.ItemCallback<Passenger>() {
        override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
            return oldItem == newItem
        }
    }
}