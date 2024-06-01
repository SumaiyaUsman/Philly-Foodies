package com.example.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
@Database(entities = {com.example.app.Foodtruck.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TruckDao truckDao();
}
