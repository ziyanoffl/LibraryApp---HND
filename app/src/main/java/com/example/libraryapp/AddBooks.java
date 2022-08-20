package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;

public class AddBooks extends AppCompatActivity {

    EditText bookNameTxt, authorTxt, descriptionTxt, priceTxt, typeTxt;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Books");
    Button addBookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        initTxtViews();
        addBookBtn = findViewById(R.id.btn_addBook);

        FirebaseMessaging.getInstance().subscribeToTopic("all");


        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bookNameTxt.getText().toString().isEmpty()){
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all","New book added!",bookNameTxt.getText().toString(),getApplicationContext(),AddBooks.this);
                    notificationsSender.SendNotifications();
                }else{
                    Toast.makeText(AddBooks.this, "Please Enter book name!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void initTxtViews(){
        bookNameTxt =(EditText) findViewById(R.id.tv_bookTitleInput);
        authorTxt = (EditText) findViewById(R.id.tv_bookAuthorInput);
        descriptionTxt = (EditText) findViewById(R.id.tv_bookDescriptionInput);
        priceTxt = (EditText) findViewById(R.id.tv_priceInput);
        typeTxt = (EditText) findViewById(R.id.tv_bookTypeInput);
    }

    public void addBook(View view) {
        String name = bookNameTxt.getText().toString();
        String author = authorTxt.getText().toString();
        String synopsis = descriptionTxt.getText().toString();
        String type = typeTxt.getText().toString();
        String price = priceTxt.getText().toString();

        HashMap<String,String> usermap = new HashMap<>();
        usermap.put("Name",name);
        usermap.put("Author",author);
        usermap.put("Type",type);
        usermap.put("Synopsis",synopsis);
        usermap.put("Price",price);

        root.push().setValue(usermap);
        Toast.makeText(this, "Book Added Successfully!", Toast.LENGTH_SHORT).show();
    }
}