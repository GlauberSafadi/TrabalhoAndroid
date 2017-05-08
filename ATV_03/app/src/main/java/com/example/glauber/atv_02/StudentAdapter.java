package com.example.glauber.atv_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> studentsList;

    public StudentAdapter(Context context, ArrayList<Student> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Student student = studentsList.get(position);
        View layout;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.estudantes, null);
        } else {
            layout = convertView;
        }

        TextView nome = (TextView) layout.findViewById(R.id.t1);
        nome.setText(student.getName());

        return layout;
    }
}
