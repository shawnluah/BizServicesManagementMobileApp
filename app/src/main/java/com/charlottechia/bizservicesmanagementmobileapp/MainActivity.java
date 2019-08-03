package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;
    private AsyncHttpClient client;

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

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                } else {

                    client = new AsyncHttpClient();
                    RequestParams params = new RequestParams();

                    params.add("username", username);
                    params.add("password", password);

                    client.post("http://10.0.2.2/FYP/doLoginAdmin.php", params, new JsonHttpResponseHandler() {

                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {


                                boolean status = response.getBoolean("authenticated");
                                Toast.makeText(getApplicationContext(), status+"", Toast.LENGTH_SHORT).show();
                                if (status) {

                                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                                    startActivity(intent);
                                        String userrole = response.getString("user_role");
                                        if (userrole.equalsIgnoreCase("Admin")) {
                                            openAdminHomePage();
                                        } else if (userrole.equalsIgnoreCase("Staff")) {
                                            openTaskUserPage();

                                        }

                                } else {
                                    Toast.makeText(getBaseContext(), "Create Unsucessful", Toast.LENGTH_SHORT).show();
                                }

                            } catch (JSONException e) {

                                e.printStackTrace();

                            }

                        }


                    });
                }

//                if ((username.equalsIgnoreCase("1")) && (password.equalsIgnoreCase("password"))) {
//
//                    openAdminHomePage();
//                } else if ((username.equalsIgnoreCase("2")) && (password.equalsIgnoreCase("password"))) {
//
//                    openTaskUserPage();
//                } else {
//                    etPassword.setText("");
//                    etUsername.setText("");
//
//                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
//
//                }
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
