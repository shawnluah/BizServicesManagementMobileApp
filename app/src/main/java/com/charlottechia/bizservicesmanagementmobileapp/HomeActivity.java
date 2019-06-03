package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnMC, btnMT, btnMU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMC = findViewById(R.id.btnMC);
        btnMT = findViewById(R.id.btnMT);
        btnMU = findViewById(R.id.btnMU);

        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClientAdmin();
            }
        });
        btnMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserAdmin();
            }
        });
        btnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminTaskRow();
            }
        });

    }


    public void openAdminTaskRow() {
        Intent intent  = new Intent(getBaseContext(), TaskAdminActivity.class);
        startActivity(intent);
    }

    public void openClientAdmin() {
        Intent intent2  = new Intent(getBaseContext(), ClientAdminActivity.class);
        startActivity(intent2);
    }
    public void openUserAdmin() {
        Intent intent3  = new Intent(getBaseContext(), UserAdminActivity.class);
        startActivity(intent3);
    }

}
