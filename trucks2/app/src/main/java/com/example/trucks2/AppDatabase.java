package com.example.trucks2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.trucks2.Foodtruck.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TruckDao truckDao();
}
