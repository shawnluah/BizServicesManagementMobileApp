package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsernameCreateUser);
        etPassword = findViewById(R.id.etPasswordCreateUser);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getEditableText().toString();
                String username = etUsername.getEditableText().toString();

                if ((username.equalsIgnoreCase("1")) && (password.equalsIgnoreCase("password"))) {

                    openAdminHomePage();
                } else if ((username.equalsIgnoreCase("169799978")) && (password.equalsIgnoreCase("password"))) {

                    openTaskUserPage();
                } else {
                    etPassword.setText("");
                    etUsername.setText("");

                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    public void openAdminHomePage () {
        Intent intent  = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(intent);
    }
    public void openTaskUserPage () {
        Intent intent2  = new Intent(getBaseContext(), TaskUserActivity.class);
        startActivity(intent2);
    }


}
