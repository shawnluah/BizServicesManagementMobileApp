package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class UserAdminActivity extends AppCompatActivity {

    ImageView ivAddUser;
    private ListView lvUser;
    private ArrayAdapter<User> aa;
    private ArrayList<User> alusers;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        ivAddUser = findViewById(R.id.ivAddUser);
        lvUser = findViewById(R.id.lvUser);
        client = new AsyncHttpClient();

//        alusers = new ArrayList<User>();
//        alusers.add(new User("name", 1, 1, "email", "usern","111", "admin", true));
//
//        aa = new UserAdapter(this, R.layout.customuser, users);
//        lvUser.setAdapter(aa);
//        ivAddUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openCreateUser();
//            }
//        });

//jiji
        

    }

    @Override
    protected void onResume() {
        super.onResume();

        client = new AsyncHttpClient();
        //TODO: call getListOfUsers.php to retrieve all users details
        alusers = new ArrayList<User>();
        client.get("http://10.0.2.2/FYP/getListOfUsers.php", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){

                try{
                    Log.i("JSON Results: ", response.toString());
                    for (int i = 0; i < response.length(); i++){

                        JSONObject jsonObj = response.getJSONObject(i);
                        int userID = jsonObj.getInt("user_id");
                        String name = jsonObj.getString("user_name");
                        int userContact = jsonObj.getInt("user_contact_num");
                        String email = jsonObj.getString("user_email");
                        String username = jsonObj.getString("username");
                        String password = jsonObj.getString("password");
                        String userStatus = jsonObj.getString("user_status");
                        String role = jsonObj.getString("user_role");
                        Boolean userStatusBool;

                        if (userStatus.equalsIgnoreCase("Active")) {
                            userStatusBool = true;
                        } else {
                            userStatusBool = false;
                        }


                        User users = new User(name, userID, userContact, email, username, password, role, userStatusBool );
                        alusers.add(users);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

                aa = new UserAdapter(getApplicationContext(), R.layout.customuser, alusers);
                lvUser.setAdapter(aa);

                lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                        Contact selectedContact = alContact.get(position);
//                        Intent i = new Intent(MainActivity.this, ViewContactDetailsActivity.class);
//                        i.putExtra("contact_id", selectedContact.getContactId());
//                        startActivity(i);
                    }
                });
            }//end onSuccess
        });

    }//end onResume

    public void openCreateUser () {
        Intent intent  = new Intent(getBaseContext(), CreateUserActivity.class);
        startActivity(intent);
    }


    public void openEditUser () {
        Intent intent  = new Intent(getBaseContext(), EditUserActivity.class);
        startActivity(intent);
    }

}
