package com.charlottechia.bizservicesmanagementmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TaskUserActivity extends AppCompatActivity {

    TextView tvID,tvName,tvType,tvDueDate;
    Button btnDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usertaskrow);

        tvID = findViewById(R.id.tvTaskID);
        tvName = findViewById(R.id.tvTaskName);
        tvType = findViewById(R.id.tvType);
        tvDueDate = findViewById(R.id.tvDueDate);
        btnDetails = findViewById(R.id.btnDetails);

    }
}
