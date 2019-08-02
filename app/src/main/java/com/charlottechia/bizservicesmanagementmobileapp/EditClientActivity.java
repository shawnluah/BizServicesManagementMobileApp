package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class EditClientActivity extends AppCompatActivity {

    EditText etClientName, etClientContact, etClientEmail, etClientContactPerson, etClientSecretary, etClientFYED, etDirector1, etDirector2, etDirector3, etShareHolder1, etShareHolder2;
    Button btnDeleteClient, btnUpdateClient, btnCancelEditClient;
    private int clientId;
    private AsyncHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        etClientName = findViewById(R.id.etNameCreateCreateUser);
        etClientContact = findViewById(R.id.etContactCreateCreateUser);
        etClientEmail = findViewById(R.id.etEmailCreateCreateUser);
        etClientContactPerson = findViewById(R.id.etUsernameCreateUser);
        etClientSecretary = findViewById(R.id.etPasswordCreateUser);
        etClientFYED = findViewById(R.id.etFYEDCreateClient);
        etDirector1 = findViewById(R.id.etDirector1);
        etDirector2 = findViewById(R.id.etDirector2);
        etDirector3 = findViewById(R.id.etDirector3);
        etShareHolder1 = findViewById(R.id.etShareholder1);
        etShareHolder2 = findViewById(R.id.etShareholder2);
        btnDeleteClient = findViewById(R.id.btnDeleteEditUser);
        btnUpdateClient = findViewById(R.id.btnSaveCreateCreateUser);
        btnCancelEditClient = findViewById(R.id.btnCancelCreateCreateUser);

        Intent intent = getIntent();
        clientId = intent.getIntExtra("client_id", -1);


        client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.add("client_id", String.valueOf(clientId));


        client.get("http://10.0.2.2/FYP/getClientById.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    Log.i("JSON Results: ", response.toString());

                    String clientName = response.getString("client_name");

                    String clientContactNum = response.getString("client_contact_num");

                    String clientEmail = response.getString("client_email");

                    String clientContactPerson = response.getString("client_contact_person");

                    String clientSecretary = response.getString("client_secretary");

                    String clientFYED = response.getString("client_financial_end_date");

                    String director1 = response.getString("director_1");

                    String director2 = response.getString("director_2");

                    String director3 = response.getString("director_3");

                    String shareholder1 = response.getString("shareholder_1");

                    String shareholder2 = response.getString("shareholder_2");



                    etClientName.setText(clientName);

                    etClientContact.setText(clientContactNum);

                    etClientEmail.setText(clientEmail);

                    etClientContactPerson.setText(clientContactPerson);

                    etClientSecretary.setText(clientSecretary);

                    etClientFYED.setText(clientFYED);

                    etDirector1.setText(director1);

                    etDirector2.setText(director2);

                    etDirector3.setText(director3);

                    etShareHolder1.setText(shareholder1);

                    etShareHolder2.setText(shareholder2);







                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });

        btnUpdateClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnUpdateOnClick(v);
            }
        });

        btnCancelEditClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDeleteClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnDeleteOnClick(v);
            }
        });
    }
    private void btnUpdateOnClick(View v) {
        //TODO: retrieve the updated text fields and set as parameters to be passed to updateContact.php
        String clientName = etClientName.getText().toString();
        String clientContact = etClientContact.getText().toString();
        String clientEmail = etClientEmail.getText().toString();
        String contactPerson = etClientContactPerson.getText().toString();
        String secretary = etClientSecretary.getText().toString();
        String fyed = etClientFYED.getText().toString();
        String director1 = etDirector1.getText().toString();
        String director2 = etDirector2.getText().toString();
        String director3 = etDirector3.getText().toString();
        String shareholder1 = etShareHolder1.getText().toString();
        String shareholder2 = etShareHolder2.getText().toString();


        if (clientName.length() == 0 || clientContact.length() == 0 || clientEmail.length() == 0 || contactPerson.length() == 0 || secretary.length() == 0|| fyed.length() == 0 || director1.length() == 0 || director2.length() == 0 || director3.length() == 0 || shareholder1.length() == 0 || shareholder2.length() == 0) {

            Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            RequestParams params = new RequestParams();

            params.add("client_id", String.valueOf(clientId));

            params.add("client_name", clientName);

            params.add("client_contact_person", contactPerson);

            params.add("client_contact_num", clientContact);

            params.add("client_email", clientEmail);

            params.add("client_secretary", secretary);

            params.add("client_financial_end_date", fyed);

            params.add("director_1", director1);

            params.add("director_2", director2);

            params.add("director_3", director3);

            params.add("shareholder_1", shareholder1);

            params.add("shareholder_2", shareholder2);

            params.add("client_status", "Active");


            client.post("http://10.0.2.2/FYP/updateClient.php", params, new JsonHttpResponseHandler() {

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

        RequestParams params = new RequestParams();

        params.add("client_id", String.valueOf(clientId));

        client.post("http://10.0.2.2/FYP/deleteClient.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    String message = response.getString("message");

                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });

        Toast.makeText(getApplicationContext(), "Client details successfully deleted", Toast.LENGTH_SHORT).show();

        finish();

    }//end btnDeleteOnClick
}
