package com.example.app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
@Entity
public class Foodtruck {
    public Foodtruck(String foodTruckName, String truckLocation, String truckCuisine) {
        this.foodTruckName = foodTruckName;
        this.truckLocation = truckLocation;
        this.truckCuisine = truckCuisine;
    }
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "truck_name")
    private String foodTruckName;
    @ColumnInfo(name = "truck_location")
    private String truckLocation;
    @ColumnInfo(name = "truck_cuisine")
    private String truckCuisine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public String getTruckLocation() {
        return truckLocation;
    }

    public String getTruckCuisine() {
        return truckCuisine;
    }
}
