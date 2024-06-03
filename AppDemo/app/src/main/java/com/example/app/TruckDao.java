package com.example.app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import java.util.List;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
@Dao
public interface TruckDao {
    @Query("SELECT * FROM foodtruck")
    List<com.example.app.Foodtruck> getAllFoodTrucks();
    @Insert
    void insertAll(com.example.app.Foodtruck... foodtrucks);
    @Query("SELECT * FROM foodtruck WHERE truck_cuisine = :cuisine")
    List<com.example.app.Foodtruck> getFoodTrucksByCuisine(String cuisine);

    @Delete
    void deleteFoodTruck(com.example.app.Foodtruck foodtruck);
}
