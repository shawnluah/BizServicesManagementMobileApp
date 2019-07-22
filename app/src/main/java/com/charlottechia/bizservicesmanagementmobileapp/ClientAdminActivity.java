package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClientAdminActivity extends AppCompatActivity {

    ImageView ivAdd;
    Button btnEdit, btnDetails;
    TextView tvIDAdminClient, tvNameAdminClient, tvStatusAdminClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_client);

        ivAdd = findViewById(R.id.imageView);


        ivAdd.setOnClickListener(new View.OnClickListener() {
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
