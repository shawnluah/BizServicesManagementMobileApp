package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class EditUserActivity extends AppCompatActivity {

    Button btnCancelUser, btnDeleteUser, btnUpdateUser;
    EditText etUserName, etUserContactNumber, etUserEmail, etUserUsername, etUserPassword;
    RadioGroup rgRole;
    RadioButton rb1, rb2;
    private int userId;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        etUserName = findViewById(R.id.etNameCreateCreateUser);
        etUserContactNumber = findViewById(R.id.etContactCreateCreateUser);
        etUserEmail = findViewById(R.id.etEmailCreateCreateUser);
        etUserUsername = findViewById(R.id.etUsernameCreateUser);
        etUserPassword = findViewById(R.id.etPasswordCreateUser);
        btnDeleteUser = findViewById(R.id.btnDeleteEditUser);
        btnUpdateUser = findViewById(R.id.btnSaveCreateCreateUser);
        btnCancelUser = findViewById(R.id.btnCancelCreateCreateUser);
        rgRole = findViewById(R.id.rgRole);
        rb1 = findViewById(R.id.rbAdminCreateCreateUser);
        rb2 = findViewById(R.id.rbStaffCreateCreateUser);

        Intent intent = getIntent();
        userId = intent.getIntExtra("user_id", -1);

        client = new AsyncHttpClient();

        RequestParams params = new RequestParams();

        params.add("user_id", String.valueOf(userId));

        client.get("http://10.0.2.2/FYP/getUserById.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    String userName = response.getString("user_name");

                    String userContactNumber = response.getString("user_contact_num");

                    String userEmail = response.getString("user_email");

                    String username = response.getString("username");

                    String password = response.getString("password");

                    String userRole = response.getString("user_role");

                    etUserName.setText(userName);

                    etUserContactNumber.setText(userContactNumber);

                    etUserEmail.setText(userEmail);

                    etUserUsername.setText(username);

                    etUserPassword.setText(password);

                    if (userRole.equalsIgnoreCase("Admin")) {
                        rb1.setChecked(true);
                    } else {
                        rb2.setChecked(false);
                    }




                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });


        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnUpdateOnClick(v);
            }
        });
        btnCancelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  finish();
            }
        });

        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDeleteOnClick(v);
            }
        });
    }

    private void btnUpdateOnClick(View v) {
        //TODO: retrieve the updated text fields and set as parameters to be passed to updateContact.php
        String userName = etUserName.getText().toString();

        String userContactNumber = etUserContactNumber.getText().toString();

        String userEmail = etUserEmail.getText().toString();

        String userUsername = etUserUsername.getText().toString();

        String userPassword = etUserPassword.getText().toString();

        int selectedButtonid = rgRole.getCheckedRadioButtonId();

        final RadioButton radioRole = findViewById(selectedButtonid);

        String radioRoleString = radioRole.getText().toString();

        if (userName.length() == 0 || userContactNumber.length() == 0 || userEmail.length() == 0 || userUsername.length() == 0 || userPassword.length() == 0) {

            Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();

        } else {

            RequestParams params = new RequestParams();

            params.add("user_id", String.valueOf(userId));

            params.add("user_name", userName);

            params.add("user_contact_num", userContactNumber);

            params.add("user_email", userEmail);

            params.add("username", userUsername);

            params.add("password", userPassword);

            params.add("user_role", radioRoleString);

            params.add("user_status", "Active");







            client.post("http://10.0.2.2/FYP/updateUsers.php", params, new JsonHttpResponseHandler() {

                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                    try {

                        String message = response.getString("message");

                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {

                        e.printStackTrace();

                    }

                }

            });

        }

        finish();

    }

    private void btnDeleteOnClick(View v) {
        //TODO: retrieve the id and set as parameters to be passed to deleteContact.php
        RequestParams params = new RequestParams();

        params.add("user_id", String.valueOf(userId));

        client.post("http://10.0.2.2/FYP/deleteUser.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    String message = response.getString("message");

                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });

        Toast.makeText(getApplicationContext(), "User details successfully deleted", Toast.LENGTH_SHORT).show();

        finish();

    }//end btnDeleteOnClick
}
