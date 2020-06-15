package com.example.mojoohoi.view.history

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojoohoi.R
import com.example.mojoohoi.client.dto.OrderItem
import com.example.mojoohoi.client.StorageComponent
import com.example.mojoohoi.view.basket.adapter.BasketAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class HistoryFragment : Fragment() {//захиалгийн түүх харах хэсгийг хийх

    var storageComponent: StorageComponent? = null
    var historyOrders: ArrayList<OrderItem>? = ArrayList();
    var recycleView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_basket, container, false)
        recycleView = root.findViewById(R.id.basketList)
        val orderButton: Button = root.findViewById(R.id.orderButton)
        orderButton.visibility = View.GONE
        initView()
        return root
    }

    private fun initView() {
        storageComponent = StorageComponent(context)
        getStorage()
        recycleView?.adapter = BasketAdapter(context, historyOrders)
        recycleView?.setHasFixedSize(true)
        recycleView?.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    fun getStorage() {
        val sharedPrefrences: SharedPreferences =
            requireContext().getSharedPreferences("LOCAL_STORAGE", 0)
        val gson = Gson()
        val json: String? = sharedPrefrences.getString("historyItems", null)
        val type: Type = object : TypeToken<List<OrderItem>>() {}.type
        historyOrders = gson.fromJson(json, type)
    }

}
