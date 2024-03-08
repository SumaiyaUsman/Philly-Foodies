package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.id_map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setTitle("Philly FoodTrucks");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng drexel = new LatLng(39.956441, -75.188686);
        googleMap.addMarker(new MarkerOptions().position(drexel).title("Drexel").snippet("Drexel University"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(drexel,12));
    }
}