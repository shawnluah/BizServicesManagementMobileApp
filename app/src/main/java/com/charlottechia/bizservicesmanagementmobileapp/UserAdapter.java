package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    public static final String LOG_TAG = UserAdapter.class.getName();

    private ArrayList<User> alUser;
    private Context context;

    public UserAdapter( Context context, int resource,ArrayList<User> objects) {
        super(context, resource,objects);
        alUser = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customuser, parent, false);

        TextView tvName = (TextView) rowView.findViewById(R.id.tvNameUser);
        TextView tvID = (TextView) rowView.findViewById(R.id.tvIDUser);
        Button btnEdit = (Button) rowView.findViewById(R.id.btnEditUserDetails);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        User user = alUser.get(position);

        tvName.setText(user.getUserName());
        tvID.setText(user.getUserId());

        return rowView;

    }





}
