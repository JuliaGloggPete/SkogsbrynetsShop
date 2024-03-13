package com.example.skogsbrynetsshop.RecycleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.Color
import com.example.skogsbrynetsshop.R
import com.example.skogsbrynetsshop.dataManagers.DataManagerColors.colors


class ColorRecycleAdapter(val context: Context, var colors: List<Color>) :
    RecyclerView.Adapter<ColorRecycleAdapter.ViewHolder>() {

    var layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.color_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = colors[position]

        holder.colorTextView.text = color.colorName
    }
    fun updateColors(newColors: List<Color>) {
        colors = newColors
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var colorTextView = itemView.findViewById<TextView>(R.id.textViewExtraColor)


    }


}