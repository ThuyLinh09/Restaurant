package com.example.ordercheftmobile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        Restaurant restaurant = (Restaurant) bundle.get("object_restaurant");
        TextView tvDetail = findViewById(R.id.detail);
        tvDetail.setText(restaurant.getName());
    }
}