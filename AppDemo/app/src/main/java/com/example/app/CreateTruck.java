package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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
                Log.d(TAG, "onClick: foodTruckName: " + foodTruckName.getText().toString());
                com.example.app.Foodtruck foodtruck = new com.example.app.Foodtruck(foodTruckName.getText().toString(), location.getText().toString(), cuisine.getText().toString());
                db.truckDao().insertAll(foodtruck);
                startActivity(new Intent(CreateTruck.this, com.example.app.MainActivity.class));
            }
        });
    }
}
