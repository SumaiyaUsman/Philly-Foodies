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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
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

        findViewById(R.id.main_post_edit).setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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
    //Mod by Chaeyoon Song 5/1/24
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
                                    Post data = new Post(documentID, title, contents);
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

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PostActivity.class);
        startActivity(intent);
    }
}