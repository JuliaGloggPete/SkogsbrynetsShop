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
import com.example.skogbrynetsverkstad.data.Color
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogsbrynetsshop.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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



        val product1 = Product("Vantar","mysiga vantar för små händer",
            "endast handtvätt", mutableListOf(".."),true,
            mutableListOf(
                Color("grey",0.0,Color.Availability.AVAILABLE),
                Color("white",0.0,Color.Availability.AVAILABLE)),false,
            null,33.0,1,0,false, Product.Availability.CUSTOM_MADE,false
        )

        //db.collection("Product").add(product1)
    /*    val docRef = db.collection("Product")
        docRef.get().addOnSuccessListener {
                collectionSnapShot ->
            for (document in collectionSnapShot.documents){
                val item = document.toObject<Product>()
                if (item != null){
                    productList.add(item)

                }
            }
            printItem()
        }*/

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