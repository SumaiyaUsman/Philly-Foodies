package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    TrucksFragment trucksFragment;
    MapFragment mapFragment;
    HomeFragment homeFragment;
    PostsFragment postsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragments
        trucksFragment = new TrucksFragment();
        mapFragment = new MapFragment();
        homeFragment = new HomeFragment();
        postsFragment = new PostsFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.truck_icon) {
                selectedFragment = trucksFragment;
            } else if (item.getItemId() == R.id.map_icon) {
                selectedFragment = mapFragment;
            } else if (item.getItemId() == R.id.home_icon) {
                selectedFragment = homeFragment;
            } else if (item.getItemId() == R.id.posts_icon) {
                selectedFragment = postsFragment;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, selectedFragment)
                        .commit();
                return true;
            }

            return false;
        });

        bottomNavigationView.setSelectedItemId(R.id.truck_icon);
    }
}
