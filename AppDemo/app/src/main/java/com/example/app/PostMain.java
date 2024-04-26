package com.example.app;

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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostMain extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mPostRecyclerView;
    private PostAdapter mAdapter;
    private List<Post> mDatas;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
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
    //Mod by Chaeyoon Song 4/20/24
    protected void onStart() {
        super.onStart();
        mDatas = new ArrayList<>();
        mStore.collection(FirebaseID.post)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Map<String, Object> shot = document.getData();
                                String documentID = shot.get(FirebaseID.documentID).toString();
                                String title = shot.get(FirebaseID.title).toString();
                                String contents = shot.get(FirebaseID.contents).toString();
                                Post data = new Post(documentID, title, contents);
                                mDatas.add(data);
                            }
                            //Author: Chaeyoon Song 4/20/24
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