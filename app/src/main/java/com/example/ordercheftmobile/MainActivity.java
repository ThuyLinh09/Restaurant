package com.example.ordercheftmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ordercheftmobile.my_interface.IClickItemRestaurantListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.menu);
        titleTextView = findViewById(R.id.title);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.list);
                        titleTextView.setText("Tất cả nhà hàng");
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.product);
                        titleTextView.setText("Sản phẩm");
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.love);
                        titleTextView.setText("Sản phẩm hot");
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.notification);
                        titleTextView.setText("Notification");
                        break;
                }
            }


        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.list) {
                    viewPager.setCurrentItem(0);
                    titleTextView.setText("Tất cả nhà hàng");
                } else if (item.getItemId() == R.id.product) {
                    viewPager.setCurrentItem(1);
                    titleTextView.setText("Sản phẩm");
                } else if (item.getItemId() == R.id.love) {
                    viewPager.setCurrentItem(2);
                    titleTextView.setText("Sản phẩm hot");
                } else if (item.getItemId() == R.id.notification) {
                    viewPager.setCurrentItem(3);
                    titleTextView.setText("Notification");
                }
                return true;
            }
        });

    }

    
}