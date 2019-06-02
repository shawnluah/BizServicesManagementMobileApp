package com.charlottechia.bizservicesmanagementmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

      //  tvTaskID = findViewById(R.id.textView16);
      // tvTaskName = findViewById(R.id.textView19);
       // tvType = findViewById(R.id.textView115);
      //   tvDueDate = findViewById(R.id.tvDueDate2);
      // btnEditTask = findViewById(R.id.btnEditTask);
      // btnDetailsTask = findViewById(R.id.btnDetailsAdmin2);


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