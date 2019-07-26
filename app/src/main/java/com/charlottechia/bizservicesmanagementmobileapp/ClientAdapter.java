package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClientAdapter extends ArrayAdapter<Client> {
    private ArrayList<Client> alClient;
    private Context context;
    private TextView tvNameClient, tvIDClient, tvStatusClient;

    public ClientAdapter( Context context, int resource,ArrayList<Client> objects) {
        super(context, resource,objects);
        alClient = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customclient, parent, false);

        tvNameClient = rowView.findViewById(R.id.tvNameClient);
        tvIDClient = rowView.findViewById(R.id.tvIDClient);
        tvStatusClient = rowView.findViewById(R.id.tvStatusClient);


        Client client = alClient.get(position);


        tvNameClient.setText(client.getClientName());
        tvIDClient.setText(client.getClientId().toString());

        return rowView;

    }
}
