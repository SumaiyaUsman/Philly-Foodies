package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Author: Sumaiya Usman 5/23/24
public class item_truck extends AppCompatActivity {

    TextView happyStar;

    TextView wokWorks;

    TextView halalTaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_truck);

        happyStar = findViewById(R.id.happystar);

        wokWorks = findViewById(R.id.wokworks);

        halalTaste = findViewById(R.id.halaltaste);

        //Author: Sumaiya Usman 5/24/24
        happyStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), happystar_menu.class);
                startActivity(intent);
                finish();
            }
        });

        //Author: Sumaiya Usman 5/25/24
        wokWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), wokworks_menu.class);
                startActivity(intent);
                finish();
            }
        });

        //Author: Sumaiya Usman 5/25/24
        halalTaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), halaltaste_menu.class);
                startActivity(intent);
                finish();
            }
        });

    }}