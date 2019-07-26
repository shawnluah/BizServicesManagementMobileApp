package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClientAdminActivity extends AppCompatActivity {

    ImageView ivAddClient;
    ListView lvClient;
    ArrayAdapter aa;
    ArrayList<Client> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_client);

        ivAddClient = findViewById(R.id.ivAddUser);
        lvClient = findViewById(R.id.lvClient);

        clients = new ArrayList<Client>();
        clients.add(new Client(1, "hue", 1111, "", "", "", "", "" , "", "", "", ""));

        aa = new ClientAdapter(this, R.layout.customclient, clients);
        lvClient.setAdapter(aa);


        ivAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateClientPage();
            }
        });



    }
    public void openEditClientPage () {
        Intent intent  = new Intent(getBaseContext(), EditClientActivity.class);
        startActivity(intent);
    }
    public void openCreateClientPage () {
        Intent intent  = new Intent(getBaseContext(), CreateClientActivity.class);
        startActivity(intent);
    }
}
