package com.example.skogbrynetsverkstad.data

import android.app.Notification.BigPictureStyle
import java.util.Date

data class Blog(
    var blogTitle: String = "",
    var blogShortDescription: String = "",
    var blogContentText: String = "",
    var blogSubtitle :String = "",
    var blogMainImagePath: String = "",
    var blogImageGridPaths: MutableList<String>?,
    var publishedDate : Date,
    var blogStatus : Status = Status.DRAFT
){
    enum class Status {
        DRAFT,
        PUBLISHED,

    }
}
