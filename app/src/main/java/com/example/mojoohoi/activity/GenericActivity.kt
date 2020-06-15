package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mojoohoi.R
import com.example.mojoohoi.view.basket.AddressFragment
import com.example.myapplication.utils.AppConstants.Companion.PAGE_PREFERENCE_TITLE

class GenericActivity : BaseActivity() {
    private var fragmentManager: FragmentManager? = null
//    private var toolbar: Toolbar? = null toolbar d oorchlolt oruulah shaardlagatai bol ashiglah

    companion object {
        var fragment = AddressFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_activity)
//        toolbar = findViewById(R.id.toolbar)
        context = this@GenericActivity
        activity = this@GenericActivity
        fragmentManager = supportFragmentManager
        configureToolbar()
        changeTitle(intent)
        initView()
    }


    private fun changeTitle(intent: Intent) {
//        val supportActionBar = supportActionBar
//        if (supportActionBar != null) {
//            toolbar!!.title = intent.getStringExtra(PAGE_PREFERENCE_TITLE)
//        }
    }


    private fun configureToolbar() {
//        setSupportActionBar(toolbar)
//        val supportActionBar = supportActionBar
//        if (supportActionBar != null) {
//            supportActionBar.setDisplayShowTitleEnabled(false)
//            toolbar!!.setNavigationOnClickListener { v: View? -> onBackPressed() }
//        }
    }

    private fun initView() {
        val fragmentTransaction =
            fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.content_frame, fragment!!)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed() {
        finish()
    }
}