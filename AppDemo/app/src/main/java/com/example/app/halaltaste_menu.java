package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//Author: Andersen Hu 5/24/24
public class halaltaste_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halal_taste);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        // Author: Sumaiya Usman, 06/2/2024
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home_icon) {
                Intent intent = new Intent(halaltaste_menu.this, ResultLogin.class);
                startActivity(intent);
            } else if (itemId == R.id.truck_icon) {
                Intent intent = new Intent(halaltaste_menu.this, Mainfoodtruck.class);
                startActivity(intent);
            } else if (itemId == R.id.posts_icon) {
                Intent intent = new Intent(halaltaste_menu.this, PostMain.class);
                startActivity(intent);
            } else if (itemId == R.id.map_icon) {
                Intent intent = new Intent(halaltaste_menu.this, map.class);
                startActivity(intent);
                return true;
            }

            return true;
        });
    }
}
