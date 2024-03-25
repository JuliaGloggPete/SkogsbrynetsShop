package com.example.skogsbrynetsshop.RecycleAdapter

import android.content.Context
import android.content.Intent
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogsbrynetsshop.PRODUCT_POSITION_KEY
import com.example.skogsbrynetsshop.ProductCreateChangeDeleteActivity
import com.example.skogsbrynetsshop.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class ProductRecycleAdapter(val products: List<Product>, val context: Context) :
    RecyclerView.Adapter<ProductRecycleAdapter.ViewHolder>() {

    var layoutInflater = LayoutInflater.from(context)


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
        holder.productPosition = position

        if (product.productPrimaryPicturePath.isNotEmpty()) {
            val imageRef = Firebase.storage.reference.child(product.productPrimaryPicturePath)
            imageRef.downloadUrl.addOnSuccessListener { Uri ->
                val imageUrl = Uri.toString()

                Glide.with(context)
                    .load(imageUrl)
                    .into(holder.productMainPicture)


            }

        }


    }


    //if(product.pr)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productNameTV = itemView.findViewById<TextView>(R.id.tv_productName)
        var productDescription = itemView.findViewById<TextView>(R.id.tv_productDescription)

        val productMainPicture = itemView.findViewById<ImageView>(R.id.imageViewMainPic)
        var productPosition = 0

        init {
            itemView.setOnClickListener {

                val intent = Intent(context, ProductCreateChangeDeleteActivity::class.java)
                intent.putExtra(PRODUCT_POSITION_KEY, productPosition)

                context.startActivity(intent)

            }


        }

    }

}