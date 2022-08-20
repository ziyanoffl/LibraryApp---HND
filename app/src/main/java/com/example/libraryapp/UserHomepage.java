package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class UserHomepage extends AppCompatActivity {

    Button locationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        //buttons
        locationBtn = (Button)findViewById(R.id.locBtn);

        Buttons();
    }

    public void Buttons(){
        locationBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent obj = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(obj);
            }
        });

    }

    public void goToViewBooks(View view) {
        final Intent obj = new Intent(getApplicationContext(),BookList.class);
        startActivity(obj);
    }

    public void goToYoutubeIntro(View view) {
        final Intent obj2 = new Intent(getApplicationContext(),UserYoutubeIntroActivity.class);
        startActivity(obj2);
    }
}