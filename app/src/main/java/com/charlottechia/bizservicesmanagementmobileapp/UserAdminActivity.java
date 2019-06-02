package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdminActivity extends AppCompatActivity {

    ImageView ivAddUser;
    TextView tvIDAdminUser,tvNameAdminuser,tvStatusAdminuser;
    Button btnEditAdminuser,btnDetailsAdminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_admin);

        ivAddUser = findViewById(R.id.ivAddUser);
        tvIDAdminUser = findViewById(R.id.tvIDAdminUser);
        tvNameAdminuser = findViewById(R.id.tvNameAdminUser);
        tvStatusAdminuser = findViewById(R.id.tvStatusAdminUser);
        btnEditAdminuser = findViewById(R.id.btnEditAdminUser);
        btnDetailsAdminUser = findViewById(R.id.btnDetailsAdminUser);

        ivAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateUser();
            }
        });

        btnEditAdminuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditUser();
            }
        });

    }

    public void openCreateUser () {
        Intent intent  = new Intent(getBaseContext(), CreateUserActivity.class);
        startActivity(intent);
    }


    public void openEditUser () {
        Intent intent  = new Intent(getBaseContext(), EditUserActivity.class);
        startActivity(intent);
    }

}
