package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostMain extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mPostRecyclerView;
    private PostAdapter mAdapter;
    private List<Post> mDatas;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    ImageView Back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpost);

        mPostRecyclerView = findViewById(R.id.recyclerview);
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.main_post_edit).setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //From Youtube 'Roon Sky' 4/20/24
    //From Blog post(loasd.tistory, zynar.tistory, aries574.tistory) 5/17/24
    //Mod by Chaeyoon Song 5/17/24
    @Override
    protected void onStart() {
        super.onStart();
        mDatas = new ArrayList<>();
        mStore.collection(FirebaseID.post)
                .orderBy(FirebaseID.timestamp, Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (queryDocumentSnapshots != null) {
                            mDatas.clear();
                            for (DocumentSnapshot snap : queryDocumentSnapshots.getDocuments()) {
                                Map<String, Object> shot = snap.getData();
                                String documentID = shot.get(FirebaseID.documentID).toString();
                                String title = shot.get(FirebaseID.title).toString();
                                String contents = shot.get(FirebaseID.contents).toString();

                                // Assuming Post has a constructor that takes these parameters and has setImageUrls method
                                Post data = new Post(documentID, title, contents);

                                // Handle the image URLs if present
                                List<String> imageUrls = (List<String>) shot.get("imageUrls");
                                if (imageUrls != null) {
                                    data.setImageUrls(imageUrls);
                                }

                                mDatas.add(data);
                            }
                            if (mAdapter == null) {
                                mAdapter = new PostAdapter(mDatas);
                                mPostRecyclerView.setAdapter(mAdapter);
                            } else {
                                mAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(PostMain.this, "Error loading posts", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PostActivity.class);
        startActivity(intent);
    }
}
