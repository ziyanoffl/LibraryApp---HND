package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    TextView username, password;
    Button adminLoginBtn;
    Boolean loggedIn;

    public Boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        initTxtviews();
    }

    public void initTxtviews(){
        username = findViewById(R.id.tvAdminUsername);
        password = findViewById(R.id.tvAdminPass);
        adminLoginBtn = findViewById(R.id.btnAdminLogin);

        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String userName =  username.getText().toString();
              String pass = password.getText().toString();

                GoToAdminHomepage(userName,pass);
            }
        });

    }

    public void GoToAdminHomepage(String username, String password){

        if(username.equals("Admin") && password.equals("pass123")){
            setLoggedIn(true);
            final Intent intent = new Intent(getApplicationContext(),AdminHomepage.class);
            startActivity(intent);

        }
        else{
            setLoggedIn(false);
            Toast.makeText(this, "Incorrect username or password! Please try again!", Toast.LENGTH_SHORT).show();

        }
    }


}