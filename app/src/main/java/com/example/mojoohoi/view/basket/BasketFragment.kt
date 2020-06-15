package com.example.mojoohoi.view.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojoohoi.R
import com.example.mojoohoi.view.basket.adapter.BasketAdapter

class BasketFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_basket, container, false)
        val recycleView: RecyclerView = root.findViewById(R.id.basketList)
        recycleView.adapter = BasketAdapter(context)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        return root
    }
}
