package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {

    private EditText mTitle, mContents;
    private String username;
    private final int GALLERY_REQ_CODE = 100;
    ImageView img1, img2, img3;
    Button reset, save;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseStorage mStorage = FirebaseStorage.getInstance();
    private StorageReference mStorageRef = mStorage.getReference();

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
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });

        // Fetch the username when the activity starts
        fetchUsername();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    //Author: Chaeyoon Song 5/23/24
    private void fetchUsername() {
        if (mAuth.getCurrentUser() != null) {
            mStore.collection("users").document(mAuth.getCurrentUser().getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful() && task.getResult() != null) {
                                username = task.getResult().getString("username");
                                if (username == null) {
                                    Toast.makeText(PostActivity.this, "Username not found in database", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(PostActivity.this, "Failed to fetch username", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    //From Youtube 'Roon Sky' 4/20/24
    //Mod by Chaeyoon Song 5/23/24
    public void savePost(View v) {
        String title = mTitle.getText().toString().trim();
        String contents = mContents.getText().toString().trim();

        if (title.isEmpty() || contents.isEmpty()) {
            Toast.makeText(this, "Title and contents must be filled", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mAuth.getCurrentUser() != null) {
            if (username == null) {
                Toast.makeText(this, "Username is not fetched yet, please wait", Toast.LENGTH_SHORT).show();
                fetchUsername();
                return;
            }
            String postId = mStore.collection("post").document().getId();
            uploadImages(postId, title, contents);
        } else {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
        }
    }

    //From Blog post(loasd.tistory, zynar.tistory, aries574.tistory) 5/17/24
    //Mod by Chaeyoon Song 5/17/24
    private void uploadImages(String postId, String title, String contents) {
        if (uri.isEmpty()) {
            savePostData(postId, title, contents, null);
            return;
        }

        ArrayList<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < uri.size(); i++) {
            Uri imageUri = uri.get(i);
            StorageReference fileRef = mStorageRef.child("posts/" + postId + "/" + imageUri.getLastPathSegment());
            int finalI = i;
            fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri downloadUri) {
                            imageUrls.add(downloadUri.toString());
                            if (finalI == uri.size() - 1) {
                                savePostData(postId, title, contents, imageUrls);
                            }
                        }
                    });
                }
            });
        }
    }

    //Mod by Chaeyoon Song 5/23/24
    private void savePostData(String postId, String title, String contents, ArrayList<String> imageUrls) {
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("title", title);
        postMap.put("contents", contents);
        postMap.put("username", username);
        postMap.put("userId", mAuth.getCurrentUser().getUid());
        postMap.put("timestamp", FieldValue.serverTimestamp());
        if (imageUrls != null) {
            postMap.put("imageUrls", imageUrls);
        }

        //Author: Chaeyoon Song 5/17/24
        //Mod by Chaeyoon Song 5/23/24
        mStore.collection("post").document(postId)
                .set(postMap, SetOptions.merge())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(PostActivity.this, "Post saved successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(PostActivity.this, "Error saving post", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                img1.setImageResource(0);
                img2.setImageResource(0);
                img3.setImageResource(0);

                uri.clear();
                ClipData clipData = data.getClipData();

                if (clipData != null) {
                    for (int i = 0; i < 3; i++) {
                        if (i < clipData.getItemCount()) {
                            Uri urione = clipData.getItemAt(i).getUri();
                            uri.add(urione);
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
                } else if (data.getData() != null) {
                    uri.add(data.getData());
                    img1.setImageURI(data.getData());
                }
            }
        }
    }
}
