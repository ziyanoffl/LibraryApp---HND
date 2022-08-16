package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    TextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        initTxtviews();
    }

    public void initTxtviews(){
        username = findViewById(R.id.tvAdminUsername);
        password = findViewById(R.id.tvAdminPass);

    }

    public void adminHomepage(View view) {
        if(username.getText().toString().equals("Admin") && password.getText().toString().equals("pass123")){
            final Intent intent = new Intent(getApplicationContext(),AdminHomepage.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Incorrect username or password! Please try again!", Toast.LENGTH_SHORT).show();
        }
    }
}