package com.charlottechia.bizservicesmanagementmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.charlottechia.bizservicesmanagementmobileapp.R;
import com.charlottechia.bizservicesmanagementmobileapp.Task;


import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> alTask;
    private Context context;
    private TextView tvNameTask, tvIDTask, tvTypeTask;

    public TaskAdapter( Context context, int resource,ArrayList<Task> objects) {
        super(context, resource,objects);
        alTask = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customtask, parent, false);

        tvNameTask = (TextView) rowView.findViewById(R.id.tvNameTask);
        tvIDTask = (TextView) rowView.findViewById(R.id.tvIDTask);
        tvTypeTask = (TextView) rowView.findViewById(R.id.tvTypeTask);


        Task task = alTask.get(position);


        tvNameTask.setText(task.getTaskName());
        tvIDTask.setText(task.getTaskId().toString());
        tvTypeTask.setText(task.getType());

        return rowView;

    }
}
