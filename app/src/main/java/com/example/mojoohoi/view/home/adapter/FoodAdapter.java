package com.example.mojoohoi.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mojoohoi.R;
import com.example.mojoohoi.client.dto.Basket;
import com.example.mojoohoi.client.dto.FoodItem;
import com.example.mojoohoi.client.dto.OrderItem;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private ArrayList<FoodItem> items;
    private Context context;

    public FoodAdapter(Context context, ArrayList<FoodItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.food_item, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        if (Basket.getInstance().isItemHaveBasket(items.get(position))) {
            imageView.setImageResource(R.drawable.ic_minus);
        } else {
            imageView.setImageResource(R.drawable.ic_add);
        }

        view.setOnClickListener(v -> {
            if (Basket.getInstance().isItemHaveBasket(items.get(position))) {
                Basket.getInstance().outOfTheBasket(this.items.get(position));
                imageView.setImageResource(R.drawable.ic_add);
            } else {
                OrderItem orderItem = new OrderItem();
                orderItem.setFoodItem(items.get(position));
                Basket.getInstance().addToBasket(orderItem);
                imageView.setImageResource(R.drawable.ic_minus);

            }
//            showInputDialog(position); хэдийг авхийг асууна тэхдээ энэд байх?
            notifyDataSetChanged();
        });
        return view;
    }

//    private void showInputDialog(int position) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Тоо хэмжээгээ оруулна уу");
//        final EditText input = new EditText(context);
//        input.setInputType(InputType.TYPE_CLASS_NUMBER);
//        builder.setView(input);
//
//        builder.setPositiveButton("Болсон", (dialog, which) -> {
//            if (!input.getText().toString().equals("")) {
//                OrderItem orderItem = new OrderItem();
//                orderItem.setFoodItem(items.get(position));
//                orderItem.setCount(Integer.parseInt(input.getText().toString()));
//                Basket.getInstance().addToBasket(orderItem);
//            }
//
//        });
//        builder.setNegativeButton("Буцах", (dialog, which) -> dialog.cancel());
//
//        builder.show();
//    }
}
