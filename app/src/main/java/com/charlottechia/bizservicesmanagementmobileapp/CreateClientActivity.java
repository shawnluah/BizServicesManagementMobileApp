package com.charlottechia.bizservicesmanagementmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class CreateClientActivity extends AppCompatActivity {

    EditText etClientName, etClientContact, etClientEmail, etContactPerson, etSecretary, etFYED, etDirector1, etDirector2, etDirector3, etShareHolder1, etShareHolder2;
    Button btnSaveClient, btnCancelSaveClient;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_client);

        etClientName = findViewById(R.id.etNameCreateCreateUser);
        etClientContact = findViewById(R.id.etContactCreateCreateUser);
        etClientEmail = findViewById(R.id.etEmailCreateCreateUser);
        etContactPerson = findViewById(R.id.etUsernameCreateUser);
        etSecretary = findViewById(R.id.etPasswordCreateUser);
        etFYED = findViewById(R.id.etFYEDCreateClient);
        etDirector1 = findViewById(R.id.etDirector1);
        etDirector2 = findViewById(R.id.etDirector2);
        etDirector3 = findViewById(R.id.etDirector3);
        etShareHolder1 = findViewById(R.id.etShareholder1);
        etShareHolder2 = findViewById(R.id.etShareholder2);

        btnSaveClient = findViewById(R.id.btnSaveCreateCreateUser);
        btnCancelSaveClient = findViewById(R.id.btnCancelCreateCreateUser);

        btnSaveClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = new AsyncHttpClient();

                String clientName = etClientName.getText().toString();
                String clientContact = etClientContact.getText().toString();
                String clientEmail = etClientEmail.getText().toString();
                String contactPerson = etContactPerson.getText().toString();
                String secretary = etSecretary.getText().toString();
                String fyed = etFYED.getText().toString();
                String director1 = etDirector1.getText().toString();
                String director2 = etDirector2.getText().toString();
                String director3 = etDirector3.getText().toString();
                String shareholder1 = etShareHolder1.getText().toString();
                String shareholder2 = etShareHolder2.getText().toString();


                if (clientName.length() == 0 || clientContact.length() == 0 || clientEmail.length() == 0 || contactPerson.length() == 0 || secretary.length() == 0|| fyed.length() == 0 || director1.length() == 0 || director2.length() == 0 || director3.length() == 0 || shareholder1.length() == 0 || shareholder2.length() == 0) {

                    Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                } else {
                    RequestParams params = new RequestParams();


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


                    client.post("http://10.0.2.2/FYP/createClients.php", params, new JsonHttpResponseHandler() {

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

        btnCancelSaveClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
