package com.example.skogsbrynetsshop.RecycleAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.OrderDetails
import com.example.skogbrynetsverkstad.data.OrderItem
import com.example.skogsbrynetsshop.R
import com.example.skogsbrynetsshop.dataManagers.DatamangerOrders.orders

class OrderRecycleAdapter( val orders: List<OrderDetails>, val context: Context) :
RecyclerView.Adapter<OrderRecycleAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from(context)


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val itemView = layoutInflater.inflate(R.layout.order_list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = orders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val order = orders[position]
        holder.orderTextView.text = order.orderNumber.toString()
        holder.setupOrderItemsRecyclerView(order.orderItems)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val orderTextView = itemView.findViewById<TextView>(R.id.textViewOrder)
        val orderItemsRecyclerView = itemView.findViewById<RecyclerView>(R.id.R_id_orderItemsRecyclerView)
       // val orderItemsRecyclerView: RecyclerView = itemView.findViewById(R.id.orderItemsRecyclerView)

        fun setupOrderItemsRecyclerView(orderItems: MutableList<OrderItem>) {
            val orderItemsAdapter = OrderItemsRecycleAdapter(orderItems, context)
            orderItemsRecyclerView.layoutManager = LinearLayoutManager(context)
            orderItemsRecyclerView.adapter = orderItemsAdapter
        }
    }

}