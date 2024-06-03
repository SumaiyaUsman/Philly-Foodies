package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import androidx.appcompat.app.AlertDialog;

//From Youtube 'DJ Malone - Android RecyclerView + Room Database Tutorial' 5/30/24
//Mod by Sumaiya Usman 5/30/24
class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.ViewHolder> {
    private List<Foodtruck> foodtrucks;
    private Context context;
    private OnFoodTruckActionListener listener;

    public FoodTruckAdapter(Context context, List<Foodtruck> foodtrucks, OnFoodTruckActionListener listener) {
        this.context = context;
        this.foodtrucks = foodtrucks;
        this.listener = listener;
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
        holder.truckName.setText(foodtruck.getFoodTruckName());
        holder.truckLocation.setText(foodtruck.getTruckLocation());
        holder.truckCuisine.setText(foodtruck.getTruckCuisine());

        // Author: Sumaiya Usman 6/1/24
        // Modified by CHATGPT 6/1/24
        holder.itemView.setOnClickListener(v -> {
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
        });
        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Are you sure you want to delete this food truck?");
            builder.setPositiveButton("Yes", (dialog, which) -> {
                if (listener != null) {
                    listener.onFoodTruckDelete(holder.getAdapterPosition());
                }
            });
            builder.setNegativeButton("No", null);
            builder.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return foodtrucks.size();
    }

    public void removeFoodTruck(int position) {
        foodtrucks.remove(position);
        notifyItemRemoved(position);
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

    public interface OnFoodTruckActionListener {
        void onFoodTruckDelete(int position);
    }
}
