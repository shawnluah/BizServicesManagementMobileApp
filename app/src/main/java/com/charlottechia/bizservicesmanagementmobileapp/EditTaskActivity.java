package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class EditTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnCancelEditTask, btnUpdateEditTask, btnDeleteTask;
    EditText etTaskName, etUserIncharge, etPercentOfUIC, etLiaisonPerson, etPercentOfLP, etTaskClient, etTaskPrice, etDueDate;
    private int taskId;
    Spinner spnType;
    private AsyncHttpClient client;
    String spinnerdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        etTaskName = findViewById(R.id.etName);
        etUserIncharge = findViewById(R.id.etUIC);
        etPercentOfUIC = findViewById(R.id.etUICPercent);
        etLiaisonPerson = findViewById(R.id.etLiaison);
        etPercentOfLP = findViewById(R.id.etPercentLP);
        etTaskClient = findViewById(R.id.etClient);
        etTaskPrice = findViewById(R.id.etPrice);
        etDueDate = findViewById(R.id.etDueDate);
        spnType = findViewById(R.id.spnType);

        btnCancelEditTask = findViewById(R.id.btnCancelCreateCreateUser);
        btnUpdateEditTask = findViewById(R.id.btnSaveCreateCreateUser);
        btnDeleteTask = findViewById(R.id.btnDeleteEditUser);

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(EditTaskActivity.this, R.array.types, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(typeAdapter);
        spnType.setOnItemSelectedListener(EditTaskActivity.this);

        Intent intent = getIntent();
        taskId = intent.getIntExtra("task_id", -1);

        client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.add("task_id", String.valueOf(taskId));

        client.get("http://10.0.2.2/FYP/getTaskById.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    Log.i("JSON Results: ", response.toString());

                    String taskName = response.getString("task_name");

                    String taskType = response.getString("task_type");

                    String userInCharge = response.getString("task_user_incharge");

                    String percentofuic = response.getString("task_percent_uic");

                    String liaisonPerson = response.getString("task_lias_person");

                    String percentliaison = response.getString("task_percent_lias_person");

                    String taskclient = response.getString("task_client");

                    String taskprice = response.getString("task_price");

                    String duedate = response.getString("task_due_date");





                    etTaskName.setText(taskName);

                    etUserIncharge.setText(userInCharge);

                    etPercentOfUIC.setText(percentofuic);

                    etLiaisonPerson.setText(liaisonPerson);

                    etPercentOfLP.setText(percentliaison);

                    etTaskClient.setText(taskclient);

                    etTaskPrice.setText(taskprice);

                    etDueDate.setText(duedate);






                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });

        btnCancelEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        btnUpdateEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnUpdateOnClick(v);
            }
        });

        btnDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDeleteOnClick(v);
            }
        });

    }
    private void btnUpdateOnClick(View v) {
        //TODO: retrieve the updated text fields and set as parameters to be passed to updateContact.php
        String taskName = etTaskName.getText().toString();
        String uic = etUserIncharge.getText().toString();
        String uicPercent = etPercentOfUIC.getText().toString();
        String liaison = etLiaisonPerson.getText().toString();
        String percentLP = etPercentOfLP.getText().toString();
        String taskClient = etTaskClient.getText().toString();
        String price = etTaskPrice.getText().toString();
        String dueDate = etDueDate.getText().toString();


        if (taskName.length() == 0 || uic.length() == 0 || uicPercent.length() == 0 || liaison.length() == 0 || percentLP.length() == 0|| taskClient.length() == 0|| price.length() == 0|| dueDate.length() == 0) {

            Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            RequestParams params = new RequestParams();

            params.add("task_id", String.valueOf(taskId));

            params.add("task_name", taskName);

            params.add("task_type", spinnerdata);

            params.add("task_user_incharge", uic);

            params.add("task_percent_uic", uicPercent);

            params.add("task_lias_person", liaison);

            params.add("task_percent_lias_person", percentLP);

            params.add("task_client", taskClient);

            params.add("task_price", price);

            params.add("task_due_date", dueDate);

            params.add("task_complete", "N");

            params.add("task_billed", "N");

            client.post("http://10.0.2.2/FYP/updateTasks.php", params, new JsonHttpResponseHandler() {

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

        params.add("task_id", String.valueOf(taskId));

        client.post("http://10.0.2.2/FYP/deleteTask.php", params, new JsonHttpResponseHandler() {

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    String message = response.getString("message");

                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {

                    e.printStackTrace();

                }

            }

        });

        Toast.makeText(getApplicationContext(), "Task details successfully deleted", Toast.LENGTH_SHORT).show();

        finish();

    }//end btnDeleteOnClick


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                if(spnType.getSelectedItemId() == 0) {
                    spinnerdata = "Accounting";
                };
                break;
            case 1:
                if(spnType.getSelectedItemId() == 1) {
                    spinnerdata = "Tax";
                };
                break;
            case 2:
                if(spnType.getSelectedItemId() == 2) {
                    spinnerdata = "Secretary";
                };
                break;
            case 3:
                if(spnType.getSelectedItemId() == 3) {
                    spinnerdata = "Consultant";
                };

                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();

    }
}
