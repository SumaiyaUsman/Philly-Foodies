package com.example.app;

import android.content.Intent;
import android.os.Bundle;

import com.example.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.app.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
public class Mainfoodtruck extends AppCompatActivity {

    RecyclerView recyclerView;
    FoodTruckAdapter adapter;
    FloatingActionButton fab;
    List<Foodtruck> foodtrucks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfoodtruck);

        recyclerView = findViewById(R.id.recycler_view);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

        if (db.truckDao().getAllFoodTrucks().isEmpty()) {
            initializeFoodTrucks(db);
        }

        foodtrucks = db.truckDao().getAllFoodTrucks();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoodTruckAdapter(this, foodtrucks);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mainfoodtruck.this, CreateTruck.class));
            }
        });

        Spinner cuisineSpinner = findViewById(R.id.cuisineSpinner);
        cuisineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCuisine = (String) parent.getItemAtPosition(position);
                filterTrucksByCuisine(selectedCuisine);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }
    private void initializeFoodTrucks(AppDatabase db) {
        Foodtruck truck1 = new Foodtruck("Happy Star", "33RD And Arch St Philadelphia, PA 19104, Powelton Village, University City", "Chinese");
        Foodtruck truck2 = new Foodtruck("Pete's Lunch Box", "11 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "American");
        Foodtruck truck3 = new Foodtruck("Aladdin Shawarma", "3508 Market St Philadelphia, PA 19104, Powelton Village, University City", "Halal");
        Foodtruck truck4 = new Foodtruck("Happy Sunshine", "33RD And Arch St Philadelphia, PA 19104, Powelton Village, University City", "American");
        Foodtruck truck5 = new Foodtruck("Judy's Kitchen", "3300 Arch St Food Truck Philadelphia, PA 19104, Powelton Village, University City", "American");
        Foodtruck truck6 = new Foodtruck("Nanu's Hot Nashville Chicken", "3301 Market St, Philadelphia, PA 19104, Powelton Village, University City", "Halal");
        Foodtruck truck7 = new Foodtruck("MEGA", "3301 Market St, Philadelphia, PA 19104, University City", "American");
        Foodtruck truck8 = new Foodtruck("Yellow Halal", "3301 Market St, Philadelphia, PA 19104, University City", "Halal");
        Foodtruck truck9 = new Foodtruck("Fruit Smoothie", "3501 Market St, Philadelphia, PA 19104, University City", "Drinks");
        Foodtruck truck10 = new Foodtruck("Divine Flavored", "3501 Market St, Philadelphia, PA 19104, University City", "African");
        Foodtruck truck11 = new Foodtruck("Richky", "2-4 N 32nd St. Philadelphia, PA 19104. Powelton Village, University City", "American");
        Foodtruck truck12 = new Foodtruck("Kami", "3233 Arch St Philadelphia, PA 19104 University City", "Korean");
        Foodtruck truck13 = new Foodtruck("NY Gyro", "3300 Market St, Philadelphia, PA 19104, University City", "Halal");
        Foodtruck truck14 = new Foodtruck("Philly Gyro", "3300 Market St, Philadelphia, PA 19104, University City", "Halal");
        Foodtruck truck15 = new Foodtruck("Hornes", "3132 Market St, Philadelphia, PA 19104, University City", "American");
        Foodtruck truck16 = new Foodtruck("Jimmy", "3101-3141 Ludlow St, Philadelphia, PA 19104, University City", "American");
        Foodtruck truck17 = new Foodtruck("Lennox", "3140 Ludlow St Philadelphia, PA 19104, University City", "American");
        Foodtruck truck18 = new Foodtruck("Ricky's", "2-4 N 32nd St Philadelphia, PA 19104, Powelton Village, University City", "American");
        Foodtruck truck19 = new Foodtruck("HJ", "3104 Ludlow St, Philadelphia, PA 19104, University City", "American");
        Foodtruck truck20 = new Foodtruck("Friendly Halal", "3300 Market St, Philadelphia, PA 19104, University City", "Halal");
        Foodtruck truck21 = new Foodtruck("Sue's Lunch Truck", "Curtis Hall, 3141 Ludlow St, Philadelphia, PA 19104, University City", "American");
        Foodtruck truck22 = new Foodtruck("Mai's Oriental Food", "3101-3141 Ludlow St, Philadelphia, PA 19104", "Chinese");
        Foodtruck truck23 = new Foodtruck("Cucina Zapata", "3101 Ludlow St, Philadelphia, PA 19104, University City", "Mexican");
        Foodtruck truck24 = new Foodtruck("Telly's", "23 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "Filipino");
        Foodtruck truck25 = new Foodtruck("WokWorks", "3000 W Sedgley Ave Philadelphia, PA 19121, University City", "Chinese");
        Foodtruck truck26 = new Foodtruck("Girale's", "Lancaster Walk", "Mexican");
        Foodtruck truck27 = new Foodtruck("Halal Taste", "12 S 33rd St, Philadelphia, PA 19104, University City", "Halal");

        // Insert food trucks into the database
        db.truckDao().insertAll(truck1, truck2, truck3, truck4, truck5, truck6, truck7, truck8, truck9, truck10, truck11, truck12, truck13, truck14, truck15, truck16, truck17, truck18, truck19, truck20, truck21, truck22, truck23, truck24, truck25, truck26, truck27);
    }
    private void filterTrucksByCuisine(String cuisine) {
        List<Foodtruck> filteredList;

        if (cuisine.equals("All")) {
            filteredList = foodtrucks;
        } else {
            filteredList = foodtrucks.stream()
                    .filter(truck -> truck.getTruckCuisine().equalsIgnoreCase(cuisine))
                    .collect(Collectors.toList());
        }

        adapter.updateList(filteredList); //updateList method
    }
}