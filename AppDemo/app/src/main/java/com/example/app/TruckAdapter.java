package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TruckAdapter extends RecyclerView.Adapter<TruckAdapter.TruckViewHolder> {

    private final List<Truck> truckList;

    public TruckAdapter(List<Truck> truckList) {
        this.truckList = truckList;
    }

    @NonNull
    @Override
    public TruckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_truck, parent, false);
        return new TruckViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruckViewHolder holder, int position) {
        Truck truck = truckList.get(position);
        holder.bind(truck);
    }

    @Override
    public int getItemCount() {
        return truckList.size();
    }

    public void updateList(List<Truck> filteredList) {
        truckList.clear();
        truckList.addAll(filteredList);
        notifyDataSetChanged();
    }

    static class TruckViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView locationTextView;
        private final TextView cuisineTypeTextView;

        public TruckViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            cuisineTypeTextView = itemView.findViewById(R.id.cuisineTypeTextView); // Add TextView for cuisine type
        }

        public void bind(@NonNull Truck truck) {
            nameTextView.setText(truck.getName());
            locationTextView.setText(truck.getLocation());
            cuisineTypeTextView.setText(truck.getCuisineType()); // Set cuisine type text
        }
    }
}
