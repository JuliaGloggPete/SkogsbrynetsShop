package com.example.skogbrynetsverkstad.data

import com.example.skogsbrynetsshop.data.BlogSupportImages

data class BlogListItemDIY(
    var listPosition : Int = 0,
    var listHeading : String?,
    var description:  String = "",
    var imagePath: String? = null,
    var position : Int = 0

)
