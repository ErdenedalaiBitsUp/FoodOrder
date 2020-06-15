package com.example.mojoohoi.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.activity.BaseActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class StorageComponent {
    protected Context context;
    protected SharedPreferences preferences;

    public StorageComponent(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences("LOCAL_STORAGE", 0);

    }

    public void setItem(String key, String value) {
        SharedPreferences.Editor var4;
        (var4 = this.getSharedPreferenceEditor(this.preferences)).putString(key, value);
        var4.apply();
    }


    public String getItem(String key) {
        return this.preferences.getString(key, (String) null);
    }

    public void removeItem(String key) {
        SharedPreferences.Editor var3;
        (var3 = this.getSharedPreferenceEditor(this.preferences)).remove(key);
        var3.apply();

    }

    public void clear() {

        for (String var2 : this.preferences.getAll().keySet()) {
            this.removeItem(var2);
        }

    }

    protected SharedPreferences.Editor getSharedPreferenceEditor(SharedPreferences preferences) {
        return preferences.edit();
    }

    public void setEventPayload(String eventName, @Nullable Object data) {
        Gson gson = new Gson();
        String gsonData = gson.toJson(data);
        this.setItem(eventName, gsonData);
    }

    public <T> T getEventPayload(String eventName, Class<T> classOfT) {
        String data = this.getItem(eventName);
        this.removeItem(eventName);
        Gson gson = new Gson();
        Log.e("asd", "getEventPayload: "+data );
        return gson.fromJson(data, classOfT);
    }


}
