package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private static final int HOME_MENU_ID = R.id.home_icon;
    private static final int TRUCK_MENU_ID = R.id.truck_icon;
    private static final int POST_MENU_ID = R.id.post_icon;
    private static final int MAP_MENU_ID = R.id.map_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(getSupportFragmentManager(), new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == HOME_MENU_ID) {
                replaceFragment(getSupportFragmentManager(), new HomeFragment());
            } else if (itemId == TRUCK_MENU_ID) {
                replaceFragment(getSupportFragmentManager(), new TrucksFragment());
            } else if (itemId == POST_MENU_ID) {
                replaceFragment(getSupportFragmentManager(), new PostsFragment());
            } else if (itemId == MAP_MENU_ID) {
                replaceFragment(getSupportFragmentManager(), new MapFragment());
            }

            return true;
        });
    }

    private void replaceFragment(FragmentManager fragmentManager, Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}