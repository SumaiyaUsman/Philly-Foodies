package com.example.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultLogin extends AppCompatActivity {

   TextView textView;
   Button PostButton;

   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_resultlogin);

       textView = findViewById(R.id.goback);
       PostButton = findViewById(R.id.btn_post);

           textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), Login.class);
               startActivity(intent);
               finish();
           }
       });
           PostButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), PostMain.class);
               startActivity(intent);
               finish();
           }
       });

           ActionBar actionBar = getSupportActionBar();
           actionBar.hide();

   }
}