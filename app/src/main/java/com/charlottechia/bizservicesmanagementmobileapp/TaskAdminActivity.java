package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskAdminActivity extends AppCompatActivity {

    TextView tvTaskID;
    TextView tvTaskName;
    TextView tvType;
    TextView tvDueDate;
    Button btnEditTask;
    Button btnDetailsTask;
    ImageView ivTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_admin);


        ivTask = findViewById(R.id.imgBtnTaskAdd);
        btnDetailsTask = findViewById(R.id.btnDetailsAdmin2);
        btnEditTask = findViewById(R.id.btnEditTask);


        ivTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateTask();
            }
        });
        btnEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditTask();
            }
        });
    }

    public void openCreateTask () {
        Intent intent  = new Intent(getBaseContext(), CreateTaskActivity.class);
        startActivity(intent);
    }
    public void openEditTask () {
        Intent intent  = new Intent(getBaseContext(), EditTaskActivity.class);
        startActivity(intent);
    }
}