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
                openCreateClient();
            }
        });
        btnMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateUser();
            }
        });
        btnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdminTaskRow();
            }
        });
    }


    public void openAdminTaskRow () {
        Intent intent  = new Intent(getBaseContext(), TaskAdminActivity.class);
        startActivity(intent);
    }

    public void openCreateClient () {
        Intent intent  = new Intent(getBaseContext(), CreateClientActivity.class);
        startActivity(intent);
    }
    public void openCreateUser () {
        Intent intent  = new Intent(getBaseContext(), CreateUserActivity.class);
        startActivity(intent);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.settings_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        if (item.getItemId()) {
////            //Do your stuff here
////            return true;
////        }
//        return super.onOptionsItemSelected(item);
//    }
}
