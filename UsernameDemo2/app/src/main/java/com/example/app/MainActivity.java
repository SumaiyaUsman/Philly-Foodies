package com.example.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    TrucksFragment trucksFragment = new TrucksFragment();
    MapFragment mapFragment = new MapFragment();
    HomeFragment homeFragment = new HomeFragment();
    PostsFragment postsFragment = new PostsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.truck_icon);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.truck_icon) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, trucksFragment)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.map_icon) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, mapFragment)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.home_icon) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, homeFragment)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.posts_icon) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, postsFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
