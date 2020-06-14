package com.example.mojoohoi.client;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private static Basket basket = new Basket();
    private static ArrayList<OrderItem> orderItems = new ArrayList<>();

    private Basket() {
    }

    public static Basket getInstance() {
        return basket;
    }

    public void addToBasket(OrderItem orderItems) {
        this.orderItems.add(orderItems);
    }

    public void outOfTheBasket(FoodItem foodItem) {
        Iterator<OrderItem> iter = this.orderItems.iterator();

        while (iter.hasNext()) {
            OrderItem orderItem = iter.next();

            if (orderItem.getFoodItem().getId().equals(foodItem.getId()))
                iter.remove();
        }
//
//        for (OrderItem orderItem : this.orderItems) {
//            if (orderItem.getFoodItem().getId().equals(foodItem.getId())) {
//                this.orderItems.remove(orderItem);
//            }
//        }
    }

    public ArrayList<OrderItem> getOrder() {
        return orderItems;
    }

    public boolean isItemHaveBasket(FoodItem foodItem) {
        for (OrderItem orderItem : this.orderItems) {
            Log.e("asdEq", "isItemHaveBasket: " + orderItem.getFoodItem().getId().equals(foodItem.getId()));
            Log.e("asdEq", "isItemHaveBasket: " + orderItem.getFoodItem().getId());
            Log.e("asdEq", "isItemHaveBasket: " + (foodItem.getId()));
            if (orderItem.getFoodItem().getId().equals(foodItem.getId())) {
                return true;
            }
        }
        return false;
    }
}
