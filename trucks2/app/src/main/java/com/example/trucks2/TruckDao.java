package com.example.trucks2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TruckDao {
    @Query("SELECT * FROM foodtruck")
    List<com.example.trucks2.Foodtruck> getAllFoodTrucks();
    @Insert
    void insertAll(com.example.trucks2.Foodtruck... foodtrucks);
    @Query("SELECT * FROM foodtruck WHERE truck_cuisine = :cuisine")
    List<com.example.trucks2.Foodtruck> getFoodTrucksByCuisine(String cuisine);
}
