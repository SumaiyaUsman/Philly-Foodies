package com.example.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ResultLogin extends AppCompatActivity {
    Button LogoutButton;

    // Mod by Sumaiya Usman 05/29/2024
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultlogin);

        LogoutButton = findViewById(R.id.btn_logout);

        LogoutButton.setOnClickListener(new View.OnClickListener() { // Set onClick listener for logout button
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        // Author: Sumaiya Usman, 04/13/2024
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // Mod by Chaeyoon Song, 05/30/2024
            if (itemId == R.id.home_icon) {
                Intent intent = new Intent(ResultLogin.this, ResultLogin.class);
                startActivity(intent);
            } else if (itemId == R.id.truck_icon) {
                Intent intent = new Intent(ResultLogin.this, item_truck.class);
                startActivity(intent);
                // Mod by Sumaiya Usman, 05/29/2024
            } else if (itemId == R.id.posts_icon) {
                Intent intent = new Intent(ResultLogin.this, PostMain.class);
                startActivity(intent);
            } else if (itemId == R.id.map_icon) {
                Intent intent = new Intent(ResultLogin.this, map.class);
                startActivity(intent);
                return true;
            }

            return true;
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}