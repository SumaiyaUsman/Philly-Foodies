package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
public class CreateTruck extends AppCompatActivity {

    private static final String TAG = "CreateTruck";
    EditText foodTruckName;
    EditText location;
    EditText cuisine;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_truck);

        foodTruckName = findViewById(R.id.truck_name);
        location = findViewById(R.id.truck_location);
        cuisine = findViewById(R.id.truck_cuisine);
        button = findViewById(R.id.add_truck_button);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodTruckName.getText().toString().trim().isEmpty() ||
                        location.getText().toString().trim().isEmpty() ||
                        cuisine.getText().toString().trim().isEmpty()) {
                    Toast.makeText(CreateTruck.this, "Enter information", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "onClick: foodTruckName: " + foodTruckName.getText().toString());
                    com.example.app.Foodtruck foodtruck = new com.example.app.Foodtruck(foodTruckName.getText().toString(), location.getText().toString(), cuisine.getText().toString());
                    db.truckDao().insertAll(foodtruck);
                    startActivity(new Intent(CreateTruck.this, com.example.app.Mainfoodtruck.class));
                }
            }
        });
        // Author: Sumaiya Usman, 06/2/2024
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home_icon) {
                Intent intent = new Intent(CreateTruck.this, ResultLogin.class);
                startActivity(intent);
            } else if (itemId == R.id.truck_icon) {
                Intent intent = new Intent(CreateTruck.this, Mainfoodtruck.class);
                startActivity(intent);
            } else if (itemId == R.id.posts_icon) {
                Intent intent = new Intent(CreateTruck.this, PostMain.class);
                startActivity(intent);
            } else if (itemId == R.id.map_icon) {
                Intent intent = new Intent(CreateTruck.this, map.class);
                startActivity(intent);
                return true;
            }

            return true;
        });
    }
}
