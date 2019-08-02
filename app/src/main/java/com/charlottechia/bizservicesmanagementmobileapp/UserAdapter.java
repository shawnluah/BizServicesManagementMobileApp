package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class UserAdapter extends ArrayAdapter<User> {

    private ArrayList<User> alUser;
    private Context context;
    private TextView tvNameUser, tvIDUser, tvStatusUser;


    public UserAdapter( Context context, int resource,ArrayList<User> objects) {
        super(context, resource,objects);
        alUser = objects;
        this.context = context;
    }
//    public void update(ArrayList<User> results) {
//        alUser = new ArrayList<>();
//        alUser.addAll(results);
//        notifyDataSetChanged(); // indicates android that the user listview need to be refreshed and the listview gets refresh immediately with the current arraylist
//    }

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
        if (user.getStatus() == true) {
            tvStatusUser.setText("Active");
        } else {
            tvStatusUser.setText("Inactive");
        }


        return rowView;

    }

//    public ArrayList<User> getData () {
//        return alUser;
//    }

//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        alUser.clear();
//        if (charText.length() == 0) {
//            alUser.addAll(alUser);
//        } else {
//            for (User users : alUser) {
//                if (users.getUserName().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    alUser.add(users);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

}
