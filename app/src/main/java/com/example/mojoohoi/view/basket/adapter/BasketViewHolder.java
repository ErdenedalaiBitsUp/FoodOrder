package com.example.mojoohoi.view.basket.adapter;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mojoohoi.R;

public class BasketViewHolder extends RecyclerView.ViewHolder {
    TextView textTitle;
    TextView textDescription;
    TextView textAmount;
    Spinner spinnerQuantity;

    public BasketViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        textDescription = itemView.findViewById(R.id.textDescription);
        textAmount = itemView.findViewById(R.id.textAmount);
        spinnerQuantity = itemView.findViewById(R.id.spinnerQuantity);
    }
}
