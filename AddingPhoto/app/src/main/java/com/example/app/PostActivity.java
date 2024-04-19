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

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitle, mContents;
    private final int GALLERY_REQ_CODE = 100;
    ImageView img1, img2, img3;
    Button reset;

    ArrayList<Uri> uri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mTitle = findViewById(R.id.post_title_edit);
        mContents = findViewById(R.id.post_contents_edit);

        reset = findViewById(R.id.btn_reset);

        findViewById(R.id.post_save_button).setOnClickListener(this);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        Button btnGallery = findViewById(R.id.btnGallery);

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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), PostMain.class);
        startActivity(intent);
    }
}