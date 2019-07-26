package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdminActivity extends AppCompatActivity {

    ImageView ivAddTask;
    ListView lvTask;
    ArrayAdapter aa;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_task);


        ivAddTask = findViewById(R.id.imgBtnTaskAdd);
        lvTask = findViewById(R.id.lvTask);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("task", 1, "", 1.1, "", 1.1, "", 1.0, true, ""));

        aa = new TaskAdapter(this, R.layout.customtask, tasks);
        lvTask.setAdapter(aa);


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