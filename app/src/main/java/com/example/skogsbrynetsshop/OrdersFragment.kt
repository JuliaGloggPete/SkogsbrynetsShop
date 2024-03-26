package com.example.skogsbrynetsshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.OrderDetails

import com.example.skogsbrynetsshop.RecycleAdapter.OrderRecycleAdapter

import com.example.skogsbrynetsshop.dataManagers.DatamangerOrders
import com.google.firebase.firestore.toObject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class OrdersFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_orders, container, false)


        val recyclerView = view.findViewById<RecyclerView>(R.id.orderItemsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = OrderRecycleAdapter(DatamangerOrders.orders, requireContext())
        recyclerView.adapter = adapter

        val docRef = db.collection("Orders")

        docRef.addSnapshotListener { collectionSnapShot, e ->
            if (e != null) {
                // Handle the error
                return@addSnapshotListener
            }

            collectionSnapShot?.let {
                val newItems = it.documents.mapNotNull { document ->
                    document.toObject<OrderDetails>()
                }

                DatamangerOrders.orders.clear()
                DatamangerOrders.orders.addAll(newItems)
               adapter.notifyDataSetChanged()
            }
        }





        return view




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrdersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrdersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}