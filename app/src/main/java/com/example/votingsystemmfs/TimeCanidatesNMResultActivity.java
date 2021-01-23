package com.example.votingsystemmfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TimeCanidatesNMResultActivity extends AppCompatActivity {
    TextView time, candidate_name;
    Button vote;
    private Candidates candidate;
    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_canidates_n_m_result);
        time = (TextView) findViewById(R.id.timeId);
        candidate_name = (TextView) findViewById(R.id.candidate_nameId);
        vote = (Button) findViewById(R.id.voteButtonId);

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(getApplicationContext());
                final List<Candidates> candidates_list = dbHelper.getData();
                final List<Users> users_list = dbHelper.getUserData();


                    candidate = candidates_list.get(1);


                    user = users_list.get(1);

                time.setText(candidate.getStart_TM());
                candidate_name.setText(candidate.getCandidate_NM());
                //vote once
                if (user.getVote() == 0){
                    int vote = user.getVote() + 1;
                    dbHelper.UpdateUserTable(user.getUserId(0), vote);
                    Toast.makeText(TimeCanidatesNMResultActivity.this, "Vote Succesfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TimeCanidatesNMResultActivity.this, "You are already taken a vote", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}