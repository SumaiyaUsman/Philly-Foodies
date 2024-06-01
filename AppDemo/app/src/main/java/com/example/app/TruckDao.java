package com.example.app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TruckDao {
    @Query("SELECT * FROM foodtruck")
    List<com.example.app.Foodtruck> getAllFoodTrucks();
    @Insert
    void insertAll(com.example.app.Foodtruck... foodtrucks);
    @Query("SELECT * FROM foodtruck WHERE truck_cuisine = :cuisine")
    List<com.example.app.Foodtruck> getFoodTrucksByCuisine(String cuisine);
}
