package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdminActivity extends AppCompatActivity {

    ImageView ivAddUser;
    ListView lvUser;
    ArrayAdapter aa;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        ivAddUser = findViewById(R.id.ivAddUser);
        lvUser = findViewById(R.id.lvUser);

        users = new ArrayList<User>();
        users.add(new User("name", 1, 1, "email", "usern","111", "admin"));

        aa = new UserAdapter(this, R.layout.customuser, users);
        lvUser.setAdapter(aa);
        ivAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateUser();
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
