package com.example.worldcup.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.worldcup.R
import com.example.worldcup.model.Country

class ListViewAdapter(private val activity: Activity, private val items: List<Country>) :
    BaseAdapter() {

    class ListAdapterViewHolder(view: View?) : ViewHolder(view!!) {
        val countryName: TextView = view!!.findViewById(R.id.country_name)
        val cupWins: TextView = view!!.findViewById(R.id.cup_wins)
        val flag: ImageView = view!!.findViewById(R.id.flag)
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Country = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val viewHolder: ListAdapterViewHolder

        if (convertView == null) {
            val inflater =
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, parent, false)
            viewHolder = ListAdapterViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ListAdapterViewHolder
        }

        val country = items[position]
        viewHolder.countryName.text = country.name
        viewHolder.cupWins.text = country.cupWins.toString()
        viewHolder.flag.setImageResource(country.flagImage)

        view?.setOnClickListener {
            Toast.makeText(activity, country.name, Toast.LENGTH_SHORT).show()
        }

        return view
    }

}