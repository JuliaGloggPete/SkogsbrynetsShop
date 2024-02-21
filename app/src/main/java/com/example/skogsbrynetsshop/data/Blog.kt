package com.example.skogbrynetsverkstad.data

import android.app.Notification.BigPictureStyle
import com.example.skogsbrynetsshop.data.BlogContentText
import java.util.Date

data class Blog(
    var blogTitle: String = "",
    var blogShortDescription: String = "",
    var blogContentText: MutableList<BlogContentText>? =mutableListOf<BlogContentText>(),
    var blogListItemDIY: MutableList<BlogListItemDIY>? = mutableListOf<BlogListItemDIY>(),

    var publishedDate : Date? =null,
    var blogOnline : Boolean = false
)

