package com.example.trucks2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.ViewHolder> {
    List<Foodtruck> foodtrucks;

    public FoodTruckAdapter(List<Foodtruck> foodtrucks) {
        this.foodtrucks = foodtrucks;
    }

    @NonNull
    @Override
    public FoodTruckAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.truck_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodTruckAdapter.ViewHolder holder, int position) {
        holder.truckName.setText(foodtrucks.get(position).getFoodTruckName());
        holder.truckLocation.setText(foodtrucks.get(position).getTruckLocation());
        holder.truckCuisine.setText(foodtrucks.get(position).getTruckCuisine());
    }

    @Override
    public int getItemCount() {
        return foodtrucks.size();
    }

    public void updateList(List<Foodtruck> newList) {
        foodtrucks = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView truckName;
        public TextView truckLocation;
        public TextView truckCuisine;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            truckName = itemView.findViewById(R.id.truck_name);
            truckLocation = itemView.findViewById(R.id.truck_location);
            truckCuisine = itemView.findViewById(R.id.truck_cuisine);
        }
    }
}
