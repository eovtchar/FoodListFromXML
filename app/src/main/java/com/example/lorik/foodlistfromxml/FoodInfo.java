package com.example.lorik.foodlistfromxml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class FoodInfo extends Activity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_info);
        Log.v(TAG,"id" + getIntent().getStringExtra("foodSendID"));
    }



}
