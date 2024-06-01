package com.example.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.app.Foodtruck.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TruckDao truckDao();
}
