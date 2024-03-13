package com.example.skogsbrynetsshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.skogbrynetsverkstad.data.Blog
import com.example.skogbrynetsverkstad.data.Color
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogbrynetsverkstad.data.Size
import com.example.skogsbrynetsshop.data.BlogContentText
import com.example.skogsbrynetsshop.data.BlogSupportImages
import com.example.skogsbrynetsshop.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.checkerframework.checker.units.qual.s

val db = Firebase.firestore
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {





    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    //https://www.youtube.com/watch?v=3VIzc_uhUCQ  16
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val product5 = Product("Selleriesalt","Sellerie och salt torkat, passer " +
                "utmärkt till soppor och saucer", "förvaras torrt","Sellerisalt",
        mutableListOf("kryddor","handgjort"),"", mutableListOf(""), false,
            mutableListOf(Color("")),true, mutableListOf(Size("L",5.0,Size.Availability.AVAILABLE),
                Size("M", 2.5, Size.Availability.AVAILABLE ), Size("S",null, Size.Availability.AVAILABLE)
            ),
            25.0, 1,12,false,Product.Availability.AVAILABLE,true
        )

        val product6 = Product("Kryddsalt","Kryddor och salt torkat, passer " +
                "utmärkt till soppor och saucer", "förvaras torrt","Sellerisalt",
            mutableListOf("kryddor","handgjort"),"", mutableListOf(""), false,
            mutableListOf(Color("")),true, mutableListOf(Size("L",5.0,Size.Availability.AVAILABLE),
                Size("M", 2.5, Size.Availability.AVAILABLE ), Size("S",null, Size.Availability.AVAILABLE)),
            25.0, 1,12,false,Product.Availability.AVAILABLE,true
        )
       // db.collection("Product").add(product6)
        //db.collection("Product").add(product5)


       /* val product3 = Product("Sittunderlägg","mysig sittunderläg",
            "endast handtvätt", mutableListOf(""),true,
            mutableListOf(
                Color("grey",0.0,Color.Availability.AVAILABLE),
                Color("white",0.0,Color.Availability.AVAILABLE)),false,
            null,33.0,1,0,false, Product.Availability.CUSTOM_MADE,false
        )

        db.collection("Product").add(product4)
        db.collection("Product").add(product4)

        val blog1 = Blog("Återvinning är kul","Enkel väg att återvinna",
            mutableListOf(BlogContentText("","",null,3,1)),
            null,null,false
        )

        val blog2 = Blog("hej","hallo",null,null,null,
            false)

       // db. collection("Blog").add(blog1)
        //db. collection("Blog").add(blog2)*/
        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemReselectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_blogg -> openFragment(BlogsFragment())
                R.id.bottom_product -> openFragment(ProductsFragment())
                R.id.bottom_orders -> openFragment(OrdersFragment())
            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())
        binding.fab.setOnClickListener{
            Toast.makeText(this, "Categories", Toast.LENGTH_SHORT).show()
        }
    }

   /* fun printItem(){
        for (item in productList) {
            Log.d("DDD", "${item.productTitle}")

        }
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
          R.id.nav_orders -> openFragment(OrdersFragment())
            R.id.nav_products -> openFragment(ProductsFragment())
            R.id.nav_bloggs -> openFragment(BlogsFragment())
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {

            super.getOnBackPressedDispatcher().onBackPressed()

        }

    }

    private fun openFragment(fragment: Fragment)
    {

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()



    }
}