package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

        tvTaskID = findViewById(R.id.tvTaskID);
       tvTaskName = findViewById(R.id.tvTaskName);
        tvType = findViewById(R.id.tvType);
         tvDueDate = findViewById(R.id.tvDueDate);
       btnEditTask = findViewById(R.id.btnEditTask);
       btnDetailsTask = findViewById(R.id.btnDetailsAdmin);


      //  ibtnCreateTask.setOnClickListener(new View.OnClickListener() {
       //     @Override
        //    public void onClick(View view) {
       //         OpenCreateTaskActivity();
       //     }
      //  });


    }

   // public  void openCreateTaskActivity(){
   //    Intent intent = new Intent(getBaseContext(),CreateTaskActivity.class);
    //    startActivity(intent);
   // }

}