package com.example.skogsbrynetsshop.RecycleAdapter

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.Blog
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import com.example.skogsbrynetsshop.R

class BlogRecycleAdapter(val context: Context, val blogs : List<Blog>) :
    RecyclerView.Adapter<BlogRecycleAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.blog_list_item, parent, false)

        return ViewHolder(itemView)

    }

    override fun getItemCount() = blogs.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val blog = blogs[position]
        holder.blogTitleTV.text = blog.blogTitle
        holder.blogShortDescrTV.text = blog.blogShortDescription
        holder.toggleOnline.isChecked = blog.blogOnline




    }


    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val blogTitleTV = itemView.findViewById<TextView>(R.id.tv_bloggTitle)
        val blogShortDescrTV = itemView.findViewById<TextView>(R.id.tv_bloggShortDescription)
        val toggleOnline = itemView.findViewById<Switch>(R.id.toggleOnline)
        val blogChangeButton = itemView.findViewById<ImageButton>(R.id.imButton_changeBlog)



    }


}