package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TrucksFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Truck> truckList;
    private TruckAdapter truckAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trucks, container, false);

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize list of trucks
        truckList = new ArrayList<>();
        // Add sample truck data
        truckList.add(new Truck("Happy Star", "Location 1"));
        truckList.add(new Truck("Pete's Lunch Box", "Location 2"));
        truckList.add(new Truck("Aladdin Shawarma", "Location 1"));
        truckList.add(new Truck("Happy Sunshine", "Location 2"));
        truckList.add(new Truck("Judy Kitchen", "Location 1"));
        truckList.add(new Truck("Nanu's Hot Nashville Chicken", "Location 2"));
        truckList.add(new Truck("MEGA", "Location 1"));
        truckList.add(new Truck("Yellow Halal", "Location 2"));
        truckList.add(new Truck("Fruit Smoothie", "Location 1"));
        truckList.add(new Truck("Divine Flavored", "Location 2"));
        truckList.add(new Truck("Richky", "Location 1"));
        truckList.add(new Truck("Kami", "Location 2"));
        truckList.add(new Truck("NY Gyro", "Location 1"));
        truckList.add(new Truck("Philly Gyro", "Location 2"));
        truckList.add(new Truck("Hornes", "Location 1"));
        truckList.add(new Truck("Jimmy", "Location 2"));
        truckList.add(new Truck("Lennox", "Location 1"));
        truckList.add(new Truck("Ricky's", "Location 2"));
        truckList.add(new Truck("HJ", "Location 1"));
        truckList.add(new Truck("Friendly Halal", "Location 2"));
        truckList.add(new Truck("Sue", "Location 1"));
        truckList.add(new Truck("Mai", "Location 2"));
        truckList.add(new Truck("Cucina", "Location 1"));
        truckList.add(new Truck("Telly's", "Location 2"));
        truckList.add(new Truck("WokWorks", "Location 1"));
        truckList.add(new Truck("Girale's", "Location 2"));
        // Add more trucks as needed

        // Initialize and set up adapter
        truckAdapter = new TruckAdapter(truckList);
        recyclerView.setAdapter(truckAdapter);

        return rootView;
    }
}

