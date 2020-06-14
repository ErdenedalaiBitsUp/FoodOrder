package com.example.mojoohoi.client;


public class OrderItem {
    private FoodItem foodItem;
    private int count;
    private String date;

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItems) {
        this.foodItem = foodItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
