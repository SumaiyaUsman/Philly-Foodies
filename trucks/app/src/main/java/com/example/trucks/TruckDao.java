package com.example.trucks;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TruckDao {
    @Query("SELECT * FROM foodtruck")
    List<Foodtruck> getAllFoodTrucks();
    @Insert
    void insertAll(Foodtruck... foodtrucks);
    @Query("SELECT * FROM foodtruck WHERE truck_cuisine = :cuisine")
    List<Foodtruck> getFoodTrucksByCuisine(String cuisine);
}
