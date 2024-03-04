package com.example.skogsbrynetsshop

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ToggleButton
import com.example.skogbrynetsverkstad.data.Color
import com.example.skogbrynetsverkstad.data.Size
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductCreateChangeDeleteActivity : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    lateinit var productTitleET : EditText
    lateinit var productShortDescriptionET : EditText
    lateinit var productInformationET : EditText
    lateinit var productPrice: EditText
    lateinit var productCategory: List<String> //osäker
    lateinit var productImageURI : Uri
    lateinit var availableDifferentColors : CheckBox
    lateinit var availableDifferentSizes : CheckBox
    lateinit var packageSize: String
    lateinit var imageUploadBtn: Button
    lateinit var imageFileName: String
    lateinit var productColors : List <Color>
    lateinit var productSizes : List <Size>
    lateinit var online : ToggleButton

    /*    var productTitle: String = "",
    var productDescription: String = "",
    var productInformation: String = "",
    var productImagePaths: MutableList<String> =  mutableListOf<String>(),
    var availableDifferentColors: Boolean = false,
    var colors: MutableList<Color> = mutableListOf<Color>(),
    var availableDifferentSizes: Boolean = false,
    var sizes:MutableList<Size>? = mutableListOf<Size>(),
    var price: Double = 0.0,
    var packaging: Int = 1,
    var count: Int = 0,
    var needsCustomerInput: Boolean = false,
    var availability: Availability = Availability.AVAILABLE,
    var visibleOnHomepage: Boolean = false,
    var productShortDescription: String = "",
    var category: MutableList<String> =mutableListOf<String>(),

*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_create_change_delete)

        db = Firebase.firestore




    }
}