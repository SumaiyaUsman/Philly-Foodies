package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrucksFragment extends Fragment {

    private List<Truck> truckList;
    private TruckAdapter truckAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_item_truck, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize list of trucks
        truckList = new ArrayList<>();
        // Add sample truck data
        addSampleTruckData();

        // Initialize and set up adapter
        truckAdapter = new TruckAdapter(truckList);
        recyclerView.setAdapter(truckAdapter);

        // Initialize Spinner
        Spinner cuisineSpinner = rootView.findViewById(R.id.cuisineSpinner);
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

        return rootView;

    }


    private void addSampleTruckData() {
        truckList.add(new Truck("Happy Star", "33RD And Arch St Philadelphia, PA 19104, Powelton Village, University City", "Chinese"));
        truckList.add(new Truck("Pete's Lunch Box", "11 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Aladdin Shawarma", "3508 Market St Philadelphia, PA 19104, Powelton Village, University City", "Halal"));
        truckList.add(new Truck("Happy Sunshine", "33RD And Arch St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Judy's Kitchen", "3300 Arch St Food Truck Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Nanu's Hot Nashville Chicken", "3301 Market St, Philadelphia, PA 19104, Powelton Village, University City", "Halal"));
        truckList.add(new Truck("MEGA", "3301 Market St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Yellow Halal", "3301 Market St, Philadelphia, PA 19104, University City", "Halal"));
        truckList.add(new Truck("Fruit Smoothie", "3501 Market St, Philadelphia, PA 19104, University City", "Drinks"));
        truckList.add(new Truck("Divine Flavored", "3501 Market St, Philadelphia, PA 19104, University City", "African"));
        truckList.add(new Truck("Richky", "2-4 N 32nd St. Philadelphia, PA 19104. Powelton Village, University City", "American"));
        truckList.add(new Truck("Kami", "3233 Arch St Philadelphia, PA 19104 University City", "Korean"));
        truckList.add(new Truck("NY Gyro", "3300 Market St, Philadelphia, PA 19104, University City", "Halal"));
        truckList.add(new Truck("Philly Gyro", "3300 Market St, Philadelphia, PA 19104, University City", "Halal"));
        truckList.add(new Truck("Hornes", "3132 Market St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Jimmy", "3101-3141 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Lennox", "3140 Ludlow St Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Ricky's", "2-4 N 32nd St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("HJ", "3104 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Friendly Halal", "3300 Market St, Philadelphia, PA 19104, University City", "Halal"));
        truckList.add(new Truck("Sue's Lunch Truck", "Curtis Hall, 3141 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Mai's Oriental Food", "3101-3141 Ludlow St, Philadelphia, PA 19104", "Chinese"));
        truckList.add(new Truck("Cucina Zapata", "3101 Ludlow St, Philadelphia, PA 19104, University City", "Mexican"));
        truckList.add(new Truck("Telly's", "23 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "Filipino"));
        truckList.add(new Truck("WokWorks", "3000 W Sedgley Ave Philadelphia, PA 19121, University City", "Chinese"));
        truckList.add(new Truck("Girale's", "Lancaster Walk", "Mexican"));
        truckList.add(new Truck("Halal Cart", "12 S 33rd St, Philadelphia, PA 19104, University City", "Halal"));
    }

    private void filterTrucksByCuisine(String cuisine) {
        List<Truck> filteredList;

        if (cuisine.equals("All")) {
            filteredList = truckList;
        } else {
            filteredList = truckList.stream()
                    .filter(truck -> truck.getCuisineType().equalsIgnoreCase(cuisine))
                    .collect(Collectors.toList());
        }
        truckAdapter.updateList(filteredList);
    }
}
