package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class ClientAdminActivity extends AppCompatActivity {


    ImageView ivAddClient;
    private ListView lvClient;
    private ArrayAdapter<Client> aa;
    private ArrayList<Client> alClients;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_client);

        ivAddClient = findViewById(R.id.ivAddUser);
        lvClient = findViewById(R.id.lvClient);
        client = new AsyncHttpClient();

//        alClients = new ArrayList<Client>();
//        alClients.add(new Client(1, "hue", 1111, "", "", "", "", "" , "", "", "", "", true));
//
//        aa = new ClientAdapter(this, R.layout.customclient, alClients);
//        lvClient.setAdapter(aa);
//
//
//        ivAddClient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCreateClientPage();
//            }
//        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        client = new AsyncHttpClient();
        //TODO: call getListOfClient.php to retrieve all users details
        alClients = new ArrayList<Client>();

        client.get("http://10.0.2.2/FYP/getListOfClient.php", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){

                try{
                    Log.i("JSON Results: ", response.toString());
                    for (int i = 0; i < response.length(); i++){

                        JSONObject jsonObj = response.getJSONObject(i);
                        int clientID = jsonObj.getInt("client_id");
                        String clientname = jsonObj.getString("client_name");
                        String clientContactPerson = jsonObj.getString("client_contact_person");
                        int clientContactNumber = jsonObj.getInt("client_contact_num");
                        String clientemail = jsonObj.getString("client_email");
                        String clientSecretary = jsonObj.getString("client_secretary");
                        String clientFinanceEndDate = jsonObj.getString("client_financial_end_date");
                        String directory1 = jsonObj.getString("director_1");
                        String directory2 = jsonObj.getString("director_2");
                        String directory3 = jsonObj.getString("director_3");
                        String shareholder = jsonObj.getString("shareholder_1");
                        String shareholder2 = jsonObj.getString("shareholder_2");
                        String clientstatus = jsonObj.getString("client_status");

                        Boolean clientStatusBool;

                        if (clientstatus.equalsIgnoreCase("Active")) {
                            clientStatusBool = true;
                        } else {
                            clientStatusBool = false;
                        }

                        Client clients = new Client(clientID, clientname, clientContactNumber, clientemail, clientContactPerson, clientSecretary, clientFinanceEndDate, directory1, directory2, directory3, shareholder, shareholder2 , clientStatusBool);
                        alClients.add(clients);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
                aa = new ClientAdapter(getApplicationContext(), R.layout.customclient, alClients);
                lvClient.setAdapter(aa);

                lvClient.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Client selectedClient = alClients.get(position);
                        Intent i = new Intent(ClientAdminActivity.this, EditClientActivity.class);
                        i.putExtra("client_id", selectedClient.getClientId());
                        startActivity(i);
                    }
                });
            }//end onSuccess
        });

        ivAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateClientPage();
            }
        });
    }//end onResume
    public void openEditClientPage () {
        Intent intent  = new Intent(getBaseContext(), EditClientActivity.class);
        startActivity(intent);
    }
    public void openCreateClientPage () {
        Intent intent  = new Intent(getBaseContext(), CreateClientActivity.class);
        startActivity(intent);
    }
}
