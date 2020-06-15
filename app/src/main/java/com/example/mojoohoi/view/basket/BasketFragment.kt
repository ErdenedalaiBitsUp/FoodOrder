package com.example.mojoohoi.view.basket

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojoohoi.R
import com.example.mojoohoi.client.dto.Basket
import com.example.mojoohoi.view.basket.adapter.BasketAdapter
import com.example.myapplication.activity.GenericActivity
import com.example.myapplication.utils.AppConstants.Companion.PAGE_PREFERENCE_TITLE

class BasketFragment : Fragment() {

    var recycleView: RecyclerView? = null
    var orderButton: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_basket, container, false)
        recycleView = root.findViewById(R.id.basketList)
        orderButton = root.findViewById(R.id.orderButton)
        initView()
        return root
    }

    private fun initView() {
        recycleView?.adapter = BasketAdapter(context, Basket.getInstance().order)
        recycleView?.setHasFixedSize(true)
        recycleView?.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        orderButton?.setOnClickListener {
            val intent = Intent(context, GenericActivity::class.java)
            intent.putExtra(PAGE_PREFERENCE_TITLE, "Хаяг оруулах")
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                initView();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
