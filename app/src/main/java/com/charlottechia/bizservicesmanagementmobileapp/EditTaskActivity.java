package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditTaskActivity extends AppCompatActivity {
    Button btnEditCancelUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        btnEditCancelUser = findViewById(R.id.btnCancelCreateCreateUser);

        btnEditCancelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserActivity();
            }
        });
    }



    public void openUserActivity () {
        Intent intent  = new Intent(getBaseContext(), UserAdminActivity.class);
        startActivity(intent);
    }
}
