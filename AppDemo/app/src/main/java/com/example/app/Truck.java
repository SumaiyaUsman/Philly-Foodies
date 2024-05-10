package com.example.app;

public class Truck {
    private final String name;
    private final String location;
    private final String cuisineType; // Add cuisine type field

    public Truck(String name, String location, String cuisineType) {
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType; // Initialize cuisine type
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCuisineType() {
        return cuisineType; // Add getter for cuisine type
    }
}
