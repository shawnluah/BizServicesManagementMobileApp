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
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class CreateUserActivity extends AppCompatActivity {
    EditText etName, etContact, etEmail, etUsername, etPassword;
    Button btnCancelCreateUser, btnSaveCreateUser;
    RadioGroup rgRole;

    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etName = findViewById(R.id.etNameCreateCreateUser);
        etContact = findViewById(R.id.etContactCreateCreateUser);
        etEmail = findViewById(R.id.etEmailCreateCreateUser);
        etUsername = findViewById(R.id.etUsernameCreateCreateUser);
        etPassword = findViewById(R.id.etPasswordCreateCreateUser);
        rgRole = findViewById(R.id.rgRole);


        btnCancelCreateUser = findViewById(R.id.btnCancelCreateCreateUser);
        btnSaveCreateUser = findViewById(R.id.btnSaveCreateCreateUser);

        btnSaveCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = new AsyncHttpClient();

                String name = etName.getText().toString();
                String contact = etContact.getText().toString();
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int selectedButtonid = rgRole.getCheckedRadioButtonId();
                final RadioButton radioRole = findViewById(selectedButtonid);
                String radioRoleString = radioRole.getText().toString();

                rgRole.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);

                    }
                });
                if (name.length() == 0 || contact.length() == 0 || email.length() == 0 || username.length() == 0 || password.length() == 0) {

                    Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                } else {
                    RequestParams params = new RequestParams();

                    params.add("user_name", name);

                    params.add("user_contact_num", contact);

                    params.add("user_email", email);

                    params.add("username", username);

                    params.add("password", password);

                    params.add("user_role", radioRoleString);

                    params.add("user_status", "Active");

                    client.post("http://10.0.2.2/FYP/createUsers.php", params, new JsonHttpResponseHandler() {

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

        });


        btnCancelCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    public void openCancelCreateAdmin() {
        Intent intent = new Intent(getBaseContext(), UserAdminActivity.class);
        startActivity(intent);
    }


}
