package com.example.mojoohoi.activity

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mojoohoi.R
import com.example.myapplication.activity.BaseActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.infideap.drawerbehavior.Advance3DDrawerLayout

class MainActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
//            val fragmentManager: FragmentManager = supportFragmentManager
//            val fragmentTransaction: FragmentTransaction =
//                fragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.nav_host_fragment, BasketFragment())
//            fragmentTransaction.commit()
            Toast.makeText(this,"Сагс руу шидэгдэх",Toast.LENGTH_LONG).show();
        }
        val drawerLayout: Advance3DDrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
//        val badge: TextView = findViewById(R.id.badge)//badge udirdah
//        badge.setText(Basket.getInstance().order.size)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_history,
                R.id.nav_basket
            ), drawerLayout
        )


        drawerLayout.setViewScale(Gravity.START, 0.9f)
        drawerLayout.setViewElevation(Gravity.START, 20f)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
