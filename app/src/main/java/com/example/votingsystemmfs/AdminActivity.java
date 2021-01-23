package com.example.votingsystemmfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    EditText position_nm, candidates_nm, start_tm, end_tm;
    Button save;
    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        position_nm = (EditText) findViewById(R.id.position_nameId);
        candidates_nm = (EditText) findViewById(R.id.candidates_nameId);
        start_tm = (EditText) findViewById(R.id.start_timeId);
        end_tm = (EditText) findViewById(R.id.end_timeId);
        save = (Button) findViewById(R.id.saveButtonId);

        DbHelper dbHelper = new DbHelper(AdminActivity.this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String position_nm1 = position_nm.getText().toString();
                String candidates_nm1 = candidates_nm.getText().toString();
                String start_tm1 = start_tm.getText().toString();
                String end_tm1 = end_tm.getText().toString();

                if(position_nm1.equals("") && candidates_nm1.equals("") && start_tm1.equals("") && end_tm1.equals("")){
                    Toast.makeText(AdminActivity.this, "Please Enter Candidates Info", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHelper.DataAddtoDatabase(position_nm1, candidates_nm1, start_tm1, end_tm1);
                    Toast.makeText(AdminActivity.this, "Succesfully Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

}