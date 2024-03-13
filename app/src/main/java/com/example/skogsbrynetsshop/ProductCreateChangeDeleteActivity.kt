package com.example.skogsbrynetsshop

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.ToggleButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.Color
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogbrynetsverkstad.data.Size
import com.example.skogsbrynetsshop.RecycleAdapter.ColorRecycleAdapter
import com.example.skogsbrynetsshop.dataManagers.DataManagerColors
import com.example.skogsbrynetsshop.dataManagers.DataManagerColors.colors
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductCreateChangeDeleteActivity : AppCompatActivity() {
    lateinit var db: FirebaseFirestore

    lateinit var productTitleET: EditText
    lateinit var productShortDescriptionET: EditText
    lateinit var productInformationET: EditText
    lateinit var productLongDescription: EditText
    lateinit var productPrice: EditText
    lateinit var productCategory: List<String> //osäker
    lateinit var productImageURI: Uri
    lateinit var availableDifferentColors: CheckBox
    lateinit var availableDifferentSizes: CheckBox
    lateinit var packageSize: EditText
    lateinit var imageFileName: String
    lateinit var productColors: List<Color>
    lateinit var productSizes: List<Size>
    lateinit var online: ToggleButton
    lateinit var krydda: CheckBox
    lateinit var giftIdea: CheckBox
    lateinit var sheepWol: CheckBox
    lateinit var newColor: EditText
    var colors = mutableListOf<Color>()
    lateinit var colorRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_create_change_delete)

        db = Firebase.firestore

        productTitleET = findViewById(R.id.TIET_productTitle)
        productInformationET = findViewById(R.id.TIET_productInformation)
        productShortDescriptionET = findViewById(R.id.TIET_productShortDescriptin)
        productLongDescription = findViewById(R.id.et_productDescription)
        productPrice = findViewById(R.id.editTextPrice)
        packageSize = findViewById(R.id.editTextPackaging)
        val imageUploadBtn = findViewById<Button>(R.id.btn_AddPic)
        krydda = findViewById(R.id.checkBoxHerbs)
        giftIdea = findViewById(R.id.checkBoxGiftIdea)
        sheepWol = findViewById(R.id.checkBoxSheepWoll)
        newColor = findViewById(R.id.editTextAddNewColor)

        val addButton = findViewById<Button>(R.id.btnAdd2Firebase)
        addButton.setOnClickListener {
            addProduct()

            finish()

        }


        colorRecyclerView  = findViewById<RecyclerView>(R.id.RV_color)
        //recyclerView.layoutManager = GridLayoutManager(this)
        colorRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ColorRecycleAdapter(this, colors)
        colorRecyclerView.adapter = adapter

        val addColorButton = findViewById<Button>(R.id.buttonAddColor)
        addColorButton.setOnClickListener {
            addColor()
            adapter.updateColors(DataManagerColors.colors)

        }


    }

    fun addColor(){

        val colorName = newColor.text.toString()

        val color = Color(colorName)

        DataManagerColors.colors.add(color)
        newColor.setText("")


    }

    fun addProduct() {

        var productTitle = productTitleET.text.toString()
        var productDescription = productLongDescription.text.toString()
        var productInformation = productInformationET.text.toString()
        var productShortDescription = productShortDescriptionET.text.toString()
        var productCategory = mutableListOf<String>()
        var productPrimaryPicturePath = ""
        var productImagePaths = mutableListOf<String>()
        var availableDifferentColors = false
        var colors = mutableListOf<Color>()
        var availableDifferentSizes = false
        var sizes = mutableListOf<Size>()
        var price = productPrice.text.toString().toDouble()
        var packaging = packageSize.text.toString().toInt()
        var count = 0
        var needsCustomerInput = false
        var availability = Product.Availability.AVAILABLE
        var visibleOnHomepage = false

        if (krydda.isChecked) {
            productCategory.add("krydda")
        }
        if (giftIdea.isChecked) {
            productCategory.add("giftIdea")
        }
        if (sheepWol.isChecked) {
            productCategory.add("sheepWol")
        }

        val newProduct = Product(productTitle,productDescription,productInformation,productShortDescription,
            productCategory,productPrimaryPicturePath,productImagePaths,availableDifferentColors,colors,
            availableDifferentSizes,sizes,price,packaging,count,needsCustomerInput,availability,visibleOnHomepage)

        /* val product6 = Product("Kryddsalt","Kryddor och salt torkat, passer " +
                 "utmärkt till soppor och saucer", "förvaras torrt","Sellerisalt",
             mutableListOf("kryddor","handgjort"),"", mutableListOf(""), false,
             mutableListOf(Color("")),true, mutableListOf(Size("L",5.0,Size.Availability.AVAILABLE),
                 Size("M", 2.5, Size.Availability.AVAILABLE ), Size("S",null, Size.Availability.AVAILABLE)),
             25.0, 1,12,false, Product.Availability.AVAILABLE,true
         )*/

        db.collection("Product").add(newProduct)

    }

}

