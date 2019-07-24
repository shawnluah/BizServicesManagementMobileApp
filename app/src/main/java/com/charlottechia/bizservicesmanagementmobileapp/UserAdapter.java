package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    private ArrayList<User> alUser;
    private Context context;
    private TextView tvNameUser, tvIDUser, tvStatusUser;


    public UserAdapter( Context context, int resource,ArrayList<User> objects) {
        super(context, resource,objects);
        alUser = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customuser, parent, false);

        tvNameUser = (TextView) rowView.findViewById(R.id.tvNameUser);
        tvIDUser = (TextView) rowView.findViewById(R.id.tvIDUser);
        tvStatusUser = (TextView) rowView.findViewById(R.id.tvStatusUser);


        User user = alUser.get(position);


        tvNameUser.setText(user.getUserName());
        tvIDUser.setText(user.getUserId().toString());

        return rowView;

    }





}
