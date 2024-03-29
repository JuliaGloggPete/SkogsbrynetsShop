package com.example.skogsbrynetsshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.skogbrynetsverkstad.data.Product
import com.example.skogsbrynetsshop.RecycleAdapter.ProductRecycleAdapter
import com.example.skogsbrynetsshop.dataManagers.DataManagerProducts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.toObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProductsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        val btnAddChangeProduct = view.findViewById<FloatingActionButton>(R.id.fabAddProduct)

        val recyclerView = view.findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ProductRecycleAdapter(DataManagerProducts.products, requireContext())
        recyclerView.adapter = adapter

        btnAddChangeProduct.setOnClickListener {
            val intent = Intent(requireContext(), ProductCreateChangeDeleteActivity::class.java)
            startActivity(intent)
        }

        val swipeGesture = object : SwipeGesture(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        adapter.removeProduct(viewHolder.adapterPosition)
                    }
                }




            }
        }
        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(recyclerView)


        val docRef = db.collection("Product")

        docRef.addSnapshotListener { collectionSnapShot, e ->
            if (e != null) {
                // Handle the error
                return@addSnapshotListener
            }

            collectionSnapShot?.let {
                val newItems = it.documents.mapNotNull { document ->
                    document.toObject<Product>()
                }

                DataManagerProducts.products.clear()
                DataManagerProducts.products.addAll(newItems)
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
         * @return A new instance of fragment ProductsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}