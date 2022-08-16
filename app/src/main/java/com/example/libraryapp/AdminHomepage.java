package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);
    }

    public void goToAddBooks(View view) {
        final Intent intent = new Intent(getApplicationContext(),AddBooks.class);
        startActivity(intent);
    }

    public void goToViewBooksAdmin(View view) {
        final Intent intent = new Intent(getApplicationContext(),BookList.class);
        startActivity(intent);
    }
}