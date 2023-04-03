package com.example.recyclercardview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclercardview.R
import com.example.recyclercardview.data.DataSource

class GameAdapter : Adapter<GameAdapter.GameViewHolder>() {
    private val dataset = DataSource.games

    class GameViewHolder(view: View?) : ViewHolder(view!!) {
        val name: TextView = view!!.findViewById(R.id.text)
        val image: ImageView = view!!.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return GameViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val data = dataset[position]

        holder.name.text = data.name
        holder.image.setImageResource(data.image)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                data.name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}