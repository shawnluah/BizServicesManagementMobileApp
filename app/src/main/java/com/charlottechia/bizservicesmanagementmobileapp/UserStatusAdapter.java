package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserStatusAdapter extends ArrayAdapter<UserStatus> {

    public static final String LOG_TAG = UserStatusAdapter.class.getName();

    private ArrayList<UserStatus> alUserStatus;
    private Context context;

    public UserStatusAdapter(Context context, int resource,ArrayList<UserStatus> objects) {
        super(context, resource,objects);
        alUserStatus = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customuser, parent, false);

        TextView tvStatus = (TextView) rowView.findViewById(R.id.tvStatusUser);

        UserStatus userstatus = alUserStatus.get(position);

        if(userstatus.getUserStatus()){
            tvStatus.setText("Active");
        }else{
            tvStatus.setText("Frozen");
        }



        return  rowView;
    }
}
