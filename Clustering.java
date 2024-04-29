package com.example.app;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
public class Clustering implements ClusterItem {
    private LatLng position;
    private String title;
    private String snippet;

    public Clustering() {
    }

    public Clustering(double lat,double lon, String title, String snippet) {
        this.position = new LatLng(lat,lon);
        this.title = title;
        this.snippet = snippet;
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snippet;
    }

    @Nullable
    @Override
    public Float getZIndex() {
        return null;
    }
}
