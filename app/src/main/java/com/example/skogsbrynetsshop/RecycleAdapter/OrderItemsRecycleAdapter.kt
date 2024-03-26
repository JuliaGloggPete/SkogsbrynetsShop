package com.example.skogsbrynetsshop.RecycleAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.OrderItem
import com.example.skogsbrynetsshop.R

class OrderItemsRecycleAdapter(val orderItems: List<OrderItem>, val context: Context) :
    RecyclerView.Adapter<OrderItemsRecycleAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.order_item_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = orderItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderItem = orderItems[position]
        holder.bind(orderItem)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemNameTextView: TextView = itemView.findViewById(R.id.textViewItemName)
        private val itemPriceTextView: TextView = itemView.findViewById(R.id.textViewItemPrice)
        private val itemCountTextView: TextView = itemView.findViewById(R.id.textViewItemCount)

        fun bind(orderItem: OrderItem) {
            itemNameTextView.text = orderItem.itemName
            itemPriceTextView.text = orderItem.itemPrice.toString()
            itemCountTextView.text = orderItem.itemCount.toString()
        }
    }
}
