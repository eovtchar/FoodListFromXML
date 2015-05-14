package com.example.lorik.foodlistfromxml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;


public class FoodInfo extends Activity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_info);
        String foodSendID = getIntent().getStringExtra("foodSendID");
        Log.v(TAG,"id" + foodSendID);
        TextView foodInfoName = (TextView) findViewById(R.id.foodInfoName);
        TextView foodInfoPrice = (TextView) findViewById(R.id.foodInfoPrice);
        TextView foodInfoCalories = (TextView) findViewById(R.id.foodInfoCalories);
        TextView foodInfoDesc = (TextView) findViewById(R.id.foodInfoDesc);
        try {
            XmlPullParser foodsParser = getResources().getXml(R.xml.foods);
            int eventType = foodsParser.getEventType();
            String name = "";
            String id = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name1 = foodsParser.getName();
                if (eventType == XmlPullParser.START_TAG && name1.equals("name")) {

                    id = foodsParser.getAttributeValue(null,"food_id");
                    
                    foodsParser.next();
                    name = foodsParser.getText();
                    foodInfoName.setText(name);
                    break;
                }

                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
            Toast.makeText(this, "Error XML-file loading: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }



}
