package com.example.trucks;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Foodtruck.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TruckDao truckDao();
}
