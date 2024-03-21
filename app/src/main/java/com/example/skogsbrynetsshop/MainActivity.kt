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


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


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