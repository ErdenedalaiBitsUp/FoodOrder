package com.example.mojoohoi.view.basket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mojoohoi.R;
import com.example.mojoohoi.client.dto.OrderItem;

import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketViewHolder> {
    private Context context;
    private ArrayList<OrderItem> items;

    public BasketAdapter(Context context, ArrayList<OrderItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public BasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.basket_items, null);
        return new BasketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketViewHolder holder, int position) {
        holder.textTitle.setText("Хоолны нэр : " + this.items.get(position).getFoodItem().getName());
        holder.textDescription.setText("Хоолны орц : " + this.items.get(position).getFoodItem().getDescription());
        holder.textAmount.setText("Хоолны үнэ : " + this.items.get(position).getFoodItem().getAmount());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
