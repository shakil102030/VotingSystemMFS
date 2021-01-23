package com.example.votingsystemmfs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    EditText votername;
    Button save_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        votername = (EditText) findViewById(R.id.voternameId);
        save_name = (Button) findViewById(R.id.SaveButtonId);

        DbHelper dbHelper = new DbHelper(UserActivity.this);

        save_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String votername1 = votername.getText().toString();

                if(votername1.equals("")){
                    Toast.makeText(UserActivity.this, "Please Enter Your Voter Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.UserDataAddtoDatabase(votername1);
                    Toast.makeText(UserActivity.this, "Saved Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }






}