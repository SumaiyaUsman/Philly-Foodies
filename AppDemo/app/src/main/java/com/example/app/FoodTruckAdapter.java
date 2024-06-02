package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.ViewHolder> {
    List<Foodtruck> foodtrucks;
    Context context;

    public FoodTruckAdapter(Context context ,List<Foodtruck> foodtrucks) {
        this.context = context;
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
        Foodtruck foodtruck = foodtrucks.get(position);
        holder.truckName.setText(foodtrucks.get(position).getFoodTruckName());
        holder.truckLocation.setText(foodtrucks.get(position).getTruckLocation());
        holder.truckCuisine.setText(foodtrucks.get(position).getTruckCuisine());

        //Author: Sumaiya Usman 6/1/24
        // Modified by CHATGPT 6/1/24
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (foodtruck.getFoodTruckName()) {
                    case "Happy Star":
                        context.startActivity(new Intent(context, happystar_menu.class));
                        break;
                    case "WokWorks":
                        context.startActivity(new Intent(context, wokworks_menu.class));
                        break;
                    case "Halal Taste":
                        context.startActivity(new Intent(context, halaltaste_menu.class));
                        break;
                }
            }
        });
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
