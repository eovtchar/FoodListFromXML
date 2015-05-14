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
                    if (id.equals(foodSendID))
                    {
                        foodsParser.next();
                        name = foodsParser.getText();
                        foodInfoName.setText(name);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String price = foodsParser.getText();
                        foodInfoPrice.setText(price);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String description = foodsParser.getText();
                        foodInfoDesc.setText(description);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String calories = foodsParser.getText();
                        foodInfoCalories.setText(calories);
                        break;
                    }
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
