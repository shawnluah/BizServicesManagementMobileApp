package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUserActivity extends AppCompatActivity {
    EditText etName,etId,etContact,etEmail,etUsername,etPassword;
    Button btnCancelCreateUser,btnSaveCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etName = findViewById(R.id.etNameCreateCreateUser);
        etId = findViewById(R.id.etIDCreateCreateUser);
        etContact = findViewById(R.id.etContactCreateCreateUser);
        etEmail = findViewById(R.id.etEmailCreateCreateUser);
        etUsername = findViewById(R.id.etUsernameCreateCreateUser);
        etPassword = findViewById(R.id.etPasswordCreateCreateUser);


        btnCancelCreateUser = findViewById(R.id.btnCancelCreateCreateUser);
        btnSaveCreateUser = findViewById(R.id.btnSaveCreateCreateUser);

        btnCancelCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 openCancelCreateAdmin();
            }
        });



    }


    public void openCancelCreateAdmin () {
        Intent intent  = new Intent(getBaseContext(),UserAdminActivity.class);
        startActivity(intent);
    }


}
