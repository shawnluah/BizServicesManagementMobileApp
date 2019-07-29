package com.charlottechia.bizservicesmanagementmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

public class CreateTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etTaskName, etUIC, etUICPercent, etLiaison, etPercentLP, etTaskClient, etPrice, etDueDate;
    Spinner spnType;
    Button btnSavetask, btnCancelTask;
    String spinnerdata;


    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        etTaskName = findViewById(R.id.etName);
        etUIC = findViewById(R.id.etUIC);
        etUICPercent = findViewById(R.id.etUICPercent);
        etLiaison = findViewById(R.id.etLiaison);
        etPercentLP = findViewById(R.id.etPercentLP);
        etTaskClient = findViewById(R.id.etClient);
        etPrice = findViewById(R.id.etPrice);
        etDueDate = findViewById(R.id.etDueDate);
        spnType = findViewById(R.id.spnType);
        btnSavetask = findViewById(R.id.btnSaveCreateCreateUser);
        btnCancelTask = findViewById(R.id.btnCancelCreateCreateUser);

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(CreateTaskActivity.this, R.array.types, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(typeAdapter);
        spnType.setOnItemSelectedListener(CreateTaskActivity.this);

        btnSavetask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = new AsyncHttpClient();

                String taskName = etTaskName.getText().toString();
                String uic = etUIC.getText().toString();
                String uicPercent = etUICPercent.getText().toString();
                String liaison = etLiaison.getText().toString();
                String percentLP = etPercentLP.getText().toString();
                String taskClient = etTaskClient.getText().toString();
                String price = etPrice.getText().toString();
                String dueDate = etDueDate.getText().toString();






                if (taskName.length() == 0 || uic.length() == 0 || uicPercent.length() == 0 || liaison.length() == 0 || percentLP.length() == 0|| taskClient.length() == 0|| price.length() == 0|| dueDate.length() == 0) {

                    Toast.makeText(getBaseContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                } else {
                    RequestParams params = new RequestParams();

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

                    client.post("http://10.0.2.2/FYP/createTasks.php", params, new JsonHttpResponseHandler() {

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
        btnCancelTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

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
