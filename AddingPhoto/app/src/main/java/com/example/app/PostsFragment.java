package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostsFragment extends Fragment {

    private String documentId;
    private String title;
    private String contents;

    // Empty constructor required by Fragment
    public PostsFragment() {
    }

    // Constructor with parameters
    public PostsFragment(String documentId, String title, String contents) {
        this.documentId = documentId;
        this.title = title;
        this.contents = contents;
    }

    // Setter and getter methods for documentId, title, and contents

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }
}
