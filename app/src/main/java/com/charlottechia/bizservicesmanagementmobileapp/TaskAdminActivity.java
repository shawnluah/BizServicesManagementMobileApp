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
    ImageView ivAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_task);


        ivAddTask = findViewById(R.id.imgBtnTaskAdd);



        ivAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateTask();
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