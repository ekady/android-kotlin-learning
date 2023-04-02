package com.example.vaccines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.vaccines.R
import com.example.vaccines.data.DataSource

class VaccineAdapter : Adapter<VaccineAdapter.VaccineViewHolder>() {
    private val dataset = DataSource.vaccines

    class VaccineViewHolder(view: View?) : ViewHolder(view!!) {
        val name: TextView = view!!.findViewById(R.id.text_1)
        val image: ImageView = view!!.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return VaccineViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        val data = dataset[position]

        holder.name.text = data.name
        holder.image.setImageResource(data.image)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, data.name, Toast.LENGTH_SHORT).show()
        }
    }
}