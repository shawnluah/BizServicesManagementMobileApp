package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TaskAdminActivity extends AppCompatActivity {

    ImageView ivAddTask;
    private ListView lvTask;
    private ArrayAdapter aa;
    private ArrayList<Task> altasks;
    private AsyncHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_task);


        ivAddTask = findViewById(R.id.imgBtnTaskAdd);
        lvTask = findViewById(R.id.lvTask);

//        tasks = new ArrayList<Task>();
//        tasks.add(new Task("task", 1, "", 1.1, "", 1.1, "", 1.0, true, ""));
//
//        aa = new TaskAdapter(this, R.layout.customtask, tasks);
//        lvTask.setAdapter(aa);
//
//
//        ivAddTask.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCreateTask();
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        client = new AsyncHttpClient();
        //TODO: call getListOfTasks.php to retrieve all users details
         altasks = new ArrayList<Task>();
        client.get("http://10.0.2.2/FYP/getListOfTasks.php", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){

                try{
                    Log.i("JSON Results: ", response.toString());
                    for (int i = 0; i < response.length(); i++){

                        JSONObject jsonObj = response.getJSONObject(i);
                        int taskID = jsonObj.getInt("task_id");
                        String taskname = jsonObj.getString("task_name");
                        String taskType = jsonObj.getString("task_type");
                        String taskUserInCharge = jsonObj.getString("task_user_incharge");
                        Double taskPercentUIC = jsonObj.getDouble("task_percent_uic");
                        String taskLiasonPerson = jsonObj.getString("task_lias_person");
                        Double taskPercentLiason = jsonObj.getDouble("task_percent_lias_person");
                        String taskClient = jsonObj.getString("task_client");
                        Double taskPrice = jsonObj.getDouble("task_price");
                        String taskDueDate = jsonObj.getString("task_due_date");
                        String taskComplete = jsonObj.getString("task_complete");
                        String taskBilled = jsonObj.getString("task_billed");

                        Boolean completeBool;
                        Boolean taskBilledBool;

                        if (taskBilled.equalsIgnoreCase("Y")) {
                            taskBilledBool = true;
                        } else {
                            taskBilledBool = false;
                        }

                        if (taskComplete.equalsIgnoreCase("Y")) {
                            completeBool = true;
                        } else {
                            completeBool = false;
                        }
                        Task tasks = new Task(taskname, taskID, taskUserInCharge, taskPercentUIC, taskLiasonPerson, taskPercentLiason, taskClient, taskPrice,taskDueDate, completeBool, taskType,taskBilledBool );
                        altasks.add(tasks);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

                aa = new TaskAdapter(getApplicationContext(), R.layout.customtask, altasks);
                lvTask.setAdapter(aa);

                lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Task selectedClient = altasks.get(position);
                        Intent i = new Intent(TaskAdminActivity.this, EditTaskActivity.class);
                        i.putExtra("task_id", selectedClient.getTaskId());
                        startActivity(i);
                    }
                });
            }//end onSuccess
        });

        ivAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateTask();
            }
        });

    }//end onResume
    public void openCreateTask () {
        Intent intent  = new Intent(getBaseContext(), CreateTaskActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu, menu); // inflate my menu.xml and display it in application

        MenuItem menuItem = menu.findItem(R.id.searchMenu);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) { // will gets called with every new input String in the search view
//                ArrayList<User> results = new ArrayList<>();
//
//                for(User x: alusers) {
//
//                    Log.i("aluserdata" ,x.toString());
//                    if (x.getUserName().contains(newText)) {
//
//                        results.add(x);
//                    }
//
//                }
//                ((UserAdapter)lvUser.getAdapter()).update(results); // to refresh the listview

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}