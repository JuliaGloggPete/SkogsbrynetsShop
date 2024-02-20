package com.example.skogsbrynetsshop.RecycleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogsbrynetsshop.R

class ProductRecycleAdapter(val products : List<Product>, val context: Context) : RecyclerView.Adapter<ProductRecycleAdapter.ViewHolder>() {

    var layoutInflater = LayoutInflater.from(context)


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var productNameTV = itemView.findViewById<TextView>(R.id.tv_productName)
        var productDescription = itemView.findViewById<TextView>(R.id.tv_productDescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.product_list_item, parent, false)

        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
      return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val product = products[position]
        holder.productNameTV.text = product.productTitle
        holder.productDescription.text = product.productDescription
    }


}