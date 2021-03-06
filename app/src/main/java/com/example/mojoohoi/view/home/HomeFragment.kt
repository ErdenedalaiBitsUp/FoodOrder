package com.example.mojoohoi.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.mojoohoi.R
import com.example.mojoohoi.client.dto.FoodItem
import com.example.mojoohoi.view.home.adapter.FoodAdapter
import java.util.ArrayList

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val foodGridView: GridView = root.findViewById(R.id.foodList)
        foodGridView.adapter = FoodAdapter(context, fillList());
        return root
    }

    private fun fillList(): ArrayList<FoodItem> {//static item - уудаар дүүргэлээ
        val items: ArrayList<FoodItem> = ArrayList()
        var foodItem = FoodItem()
        foodItem.id = "1"
        foodItem.name = "Тахиа"
        foodItem.description = "Тахиа будаа"
        foodItem.amount = 15000.0
        items.add(foodItem)

        foodItem = FoodItem()
        foodItem.id = "2"
        foodItem.name = "Тахиа"
        foodItem.description = "Тахиа будаа"
        foodItem.amount = 15000.0
        items.add(foodItem)

        foodItem = FoodItem()
        foodItem.id = "3"
        foodItem.name = "Тахиа"
        foodItem.description = "Тахиа будаа"
        foodItem.amount = 15000.0
        items.add(foodItem)

        foodItem = FoodItem()
        foodItem.id = "4"
        foodItem.name = "Тахиа"
        foodItem.description = "Тахиа будаа"
        foodItem.amount = 15000.0
        items.add(foodItem)

        return items;
    }
}
