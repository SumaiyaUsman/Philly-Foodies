package com.example.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {

    private EditText mTitle, mContents;
    private final int GALLERY_REQ_CODE = 100;
    ImageView img1, img2, img3;
    Button reset, save;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    ArrayList<Uri> uri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mTitle = findViewById(R.id.post_title_edit);
        mContents = findViewById(R.id.post_contents_edit);
        reset = findViewById(R.id.btn_reset);
        save = findViewById(R.id.post_save_button);


        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        Button btnGallery = findViewById(R.id.btnGallery);
        save.setOnClickListener(this::savePost);

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                uri.clear();

                img1.setImageURI(null);
                img2.setImageURI(null);
                img3.setImageURI(null);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                iGallery.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);

            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    //From Youtube 'Roon Sky' 4/20/24
    //Mod by Chaeyoon Song 4/20/24
    public void savePost(View v) {
        if (mAuth.getCurrentUser() != null) {
            String postId = mStore.collection(FirebaseID.post).document().getId();
            Map<String, Object> data = new HashMap<>();
            data.put(FirebaseID.documentID, mAuth.getCurrentUser().getUid());
            data.put(FirebaseID.title, mTitle.getText().toString());
            data.put(FirebaseID.contents, mContents.getText().toString());

            //Author: Chaeyoon Song 4/20/24
            mStore.collection(FirebaseID.post).document(postId).set(data, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "Post saved successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(this, "Error saving post", Toast.LENGTH_SHORT).show());
        } else {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if (requestCode==GALLERY_REQ_CODE) {
                img1.setImageResource(0);
                img2.setImageResource(0);
                img3.setImageResource(0);

                Uri uri = data.getData();
                ClipData clipData = data.getClipData();

                if(clipData!=null) {
                    for(int i = 0; i<3; i++) {
                        if(i<clipData.getItemCount()) {
                            Uri urione = clipData.getItemAt(i).getUri();
                            switch (i) {
                                case 0:
                                    img1.setImageURI(urione);
                                    break;
                                case 1:
                                    img2.setImageURI(urione);
                                    break;
                                case 2:
                                    img3.setImageURI(urione);
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
}