package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClientAdminActivity extends AppCompatActivity {

    ImageView ivAdd;
    Button btnEdit, btnDetails;
    TextView tvIDAdminClient, tvNameAdminClient, tvStatusAdminClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_admin);

        ivAdd = findViewById(R.id.imageView);
        btnEdit = findViewById(R.id.btnEditAdminClient);
        btnDetails = findViewById(R.id.btnDetailsAdminClient);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateClientPage();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditClientPage();
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
