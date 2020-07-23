package com.example.myprogress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentCMSAdapter extends BaseAdapter {

    LayoutInflater mInflater;// this lets you put stuff in the layout you made

    ArrayList<String> students;


    public StudentCMSAdapter(Context c, ArrayList<String> i){
        students = i;

        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    } //to create an item adapter you need a constructor so it knows where to place things
    // in the layout template

    @Override
    public int getCount() {
        return students.size();
    }//this wants the amount of values in the var

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }//if we want a piticular item in the array

    @Override
    public long getItemId(int i) {
        return i;
    }

    //this is how you present the data and use layout Tempalte you created to display in your Activity
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        //this is your view for the data to display in the layout is
        //this is the template layout first inflate the template Relativelayout
        View v = mInflater.inflate(R.layout.student_listview_list,null);

        //here you find the id of the TextView in the template(my_listview) which name is (v)
        TextView textViewStudents = (TextView) v.findViewById(R.id.textViewStudents);

        //this is the position of each data in the array
        String studentNames = students.get(i);

        textViewStudents.setText(studentNames);

        return v;
    }
}
