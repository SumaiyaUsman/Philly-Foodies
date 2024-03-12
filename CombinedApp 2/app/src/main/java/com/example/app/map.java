package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class map extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gMap;

    LatLng drexel = new LatLng(39.956441, -75.188686);
    LatLng Happy_Star = new LatLng(39.95780, -75.18921);
    LatLng Petes_lunch_box = new LatLng(39.95769, -75.18925);
    LatLng Aladdin_Shawarma = new LatLng(39.95770, -75.18940);
    LatLng Happy_Sunshine = new LatLng(39.95754, -75.18935);
    LatLng Judy_Kitchen = new LatLng(39.95756, -75.18945);
    LatLng Nanus = new LatLng(39.95600, -75.18946);
    LatLng MEGA = new LatLng(39.95591, -75.18949);
    LatLng Yellow_Halal = new LatLng(39.95580, -75.18954);
    LatLng Fruit_Smoothie = new LatLng(39.95580, -75.18954);
    LatLng Divine_Flavored = new LatLng(39.95620, -75.19318);
    LatLng Richky = new LatLng(39.95539, -75.18963);
    LatLng Kami = new LatLng(39.95524, -75.18965);
    LatLng NY_Gyro = new LatLng(39.95510, -75.18945);
    LatLng Philly_Gyro = new LatLng(39.95499, -75.18947);
    LatLng Hornes = new LatLng(39.95450, -75.18678);
    LatLng Jimmy = new LatLng(39.95447, -75.18665);
    LatLng Lennox = new LatLng(39.95444, -75.18645);
    LatLng Rickys = new LatLng(39.95443, -75.18638);
    LatLng Kims = new LatLng(39.95438, -75.18596);
    LatLng HJ = new LatLng(39.95440, -75.18621);
    LatLng Friendly_Halal = new LatLng(39.95447, -75.18976);
    LatLng Sue = new LatLng(39.95439, -75.18612);
    LatLng Mai = new LatLng(39.95436, -75.18583);
    LatLng Cucina = new LatLng(39.95434, -75.18568);

    private ArrayList<LatLng> locationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.id_map);
        mapFragment.getMapAsync(this);

        locationArrayList = new ArrayList<>();

        locationArrayList.add(drexel);
        locationArrayList.add(Happy_Star);
        locationArrayList.add(Petes_lunch_box);
        locationArrayList.add(Aladdin_Shawarma);
        locationArrayList.add(Happy_Sunshine);
        locationArrayList.add(Judy_Kitchen);
        locationArrayList.add(Nanus);
        locationArrayList.add(MEGA);
        locationArrayList.add(Yellow_Halal);
        locationArrayList.add(Fruit_Smoothie);
        locationArrayList.add(Divine_Flavored);
        locationArrayList.add(Richky);
        locationArrayList.add(Kami);
        locationArrayList.add(NY_Gyro);
        locationArrayList.add(Philly_Gyro);
        locationArrayList.add(Hornes);
        locationArrayList.add(Jimmy);
        locationArrayList.add(Lennox);
        locationArrayList.add(Rickys);
        locationArrayList.add(Kims);
        locationArrayList.add(HJ);
        locationArrayList.add(Friendly_Halal);
        locationArrayList.add(Sue);
        locationArrayList.add(Mai);
        locationArrayList.add(Cucina);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(0)).title("Drexel"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(1)).title("Happy Star"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(2)).title("Pete's Little Lunch Box"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(3)).title("Aladdin Shawarma"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(4)).title("Happy Sunshine Lunch Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(5)).title("Judy's Kitchen"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(6)).title("Nanu's Nashville Hot Chicken"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(7)).title("MEGA Food Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(8)).title("Halal Taste"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(9)).title("Fruit Smoothies"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(10)).title("Divine Flavored Catering"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(11)).title("Richky Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(12)).title("Kami Korean Food"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(13)).title("Famous New York Gyro"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(14)).title("Philly Halal Gyro"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(15)).title("Horne's Famous Food"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(16)).title("Jimmy Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(17)).title("Lennox Got Lunch"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(18)).title("Ricky's Food Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(19)).title("Kim's Dragon Asian Food"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(20)).title("H & J"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(21)).title("Friendly Tasty Dishes Halal Food"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(22)).title("Sue's Lunch Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(23)).title("Mai's Food Truck"));
        gMap.addMarker(new MarkerOptions().position(locationArrayList.get(24)).title("Cucina Zapata"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(drexel,15));

    }

}