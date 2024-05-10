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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_item_truck, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize list of trucks
        List<Truck> truckList = new ArrayList<>();
        // Add sample truck data
        truckList.add(new Truck("Happy Star", "Location 1", "Chinese"));
        truckList.add(new Truck("Pete's Lunch Box", "11 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Aladdin Shawarma", "3508 Market St Philadelphia, PA 19104, Powelton Village, University City", "Arabic"));
        truckList.add(new Truck("Happy Sunshine", "33RD And Arch St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Judy's Kitchen", "3300 Arch St Food Truck Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("Nanu's Hot Nashville Chicken", "3301 Market St, Philadelphia, PA 19104, Powelton Village, University City", "Halal"));
        truckList.add(new Truck("MEGA", "Location 1", "American"));
        truckList.add(new Truck("Yellow Halal", "Location 2", "Halal"));
        truckList.add(new Truck("Fruit Smoothie", "3501 Market St, Philadelphia, PA 19104, University City", "Drinks"));
        truckList.add(new Truck("Divine Flavored", "3501 Market St, Philadelphia, PA 19104, University City", "African"));
        truckList.add(new Truck("Richky", "2-4 N 32nd St. Philadelphia, PA 19104. Powelton Village, University City", "American"));
        truckList.add(new Truck("Kami", "3233 Arch St Philadelphia, PA 19104 University City", "Korean"));
        truckList.add(new Truck("NY Gyro", "Location 1", "Halal"));
        truckList.add(new Truck("Philly Gyro", "Location 2", "Halal"));
        truckList.add(new Truck("Hornes", "3132 Market St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Jimmy", "3101-3141 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Lennox", "3140 Ludlow St Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Ricky's", "2-4 N 32nd St Philadelphia, PA 19104, Powelton Village, University City", "American"));
        truckList.add(new Truck("HJ", "3104 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Friendly Halal", "Location 2", "Halal"));
        truckList.add(new Truck("Sue's Lunch Truck", "Curtis Hall, 3141 Ludlow St, Philadelphia, PA 19104, University City", "American"));
        truckList.add(new Truck("Mai's Oriental Food", "3101-3141 Ludlow St, Philadelphia, PA 19104", "Chinese"));
        truckList.add(new Truck("Cucina Zapata", "3101 Ludlow St, Philadelphia, PA 19104, University City", "Mexican"));
        truckList.add(new Truck("Telly's", "23 N 33rd St Philadelphia, PA 19104, Powelton Village, University City", "Filipino"));
        truckList.add(new Truck("WokWorks", "3000 W Sedgley Ave Philadelphia, PA 19121, University City", "Chinese"));
        truckList.add(new Truck("Girale's", "Location 2", "American"));
        truckList.add(new Truck("Halal Cart", "12 S 33rd St, Philadelphia, PA 19104, University City", "Halal"));
        // Add more trucks as needed

        // Initialize and set up adapter
        TruckAdapter truckAdapter = new TruckAdapter(truckList);
        recyclerView.setAdapter(truckAdapter);

        return rootView;
    }
}

