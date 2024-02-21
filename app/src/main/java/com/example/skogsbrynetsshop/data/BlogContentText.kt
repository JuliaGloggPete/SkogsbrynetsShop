package com.example.skogsbrynetsshop.data

data class BlogContentText (

    var subTitle : String = "",
    var description: String = "",
    var supportingImagePaths : MutableList<BlogSupportImages>? = mutableListOf<BlogSupportImages>(),
    var maxImages : Int = 3,
    var position : Int = 0
)