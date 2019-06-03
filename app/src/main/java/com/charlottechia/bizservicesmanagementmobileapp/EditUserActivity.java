package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditUserActivity extends AppCompatActivity {

    Button btnCanelUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        btnCanelUser = findViewById(R.id.btnCancelCreateCreateUser);

        btnCanelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  openUserAdminActivity();
            }
        });

    }

    public void openUserAdminActivity () {
        Intent intent  = new Intent(getBaseContext(), UserAdminActivity.class);
        startActivity(intent);
    }

}
