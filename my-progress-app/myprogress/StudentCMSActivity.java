package com.example.myprogress;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentCMSActivity extends AppCompatActivity {
    //make sure in activity_stendt.xml file that the layout in for the listview width is match_parent

    ListView studentListView;
    ArrayList<String> students;
    public static Context STUDENT_ACTIVITY_CONTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        STUDENT_ACTIVITY_CONTEXT = getApplicationContext();

        //gets the resources
        Resources res = getResources();
        //var that has the data of the text ListView
        studentListView = (ListView) findViewById(R.id.listViewStudents);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getStudents();

//        String type = "getStudents";
//        BackEnd Conn = new BackEnd(StudentCMSActivity.this);
//        Conn.execute(type);

        //this is the same as findViewById()
        //it takes the data from the string-array and set it to the variables
        students = BackEnd.USERS;

        //listview needs a layout to display it
        //this sets the array names to the layout
        //studentListView.setAdapter(new ArrayAdapter<String>(this, R.layout.student_listview_detail, students));


        //made the iteAdapter and set it to the listView layout in the activity_user
        //will also need to make a itemAdapter Java class with the data that will set the view
        //in the RelativeLayout template
        StudentCMSAdapter studentNameAdapter = new StudentCMSAdapter(this, students);
        studentListView.setAdapter(studentNameAdapter);

        //setOnItemClickListener = when one of the items in the listview gets clicked it will go to an new activity
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // i is the index that will be passed into detail activity
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent showResultInputActivity = new Intent(getApplicationContext(), InputResultsCMSActivity.class);
                //sending data to the activity
                showResultInputActivity.putExtra("USER_NAME", students.get(i));//may need the package name, which is in the first line off code
                Log.d("CLICKED USERNAME: ",students.get(i));
                startActivity(showResultInputActivity);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //BackEnd.USER_GOAL will have the same elements in the array if you dont set the value to an array
        BackEnd.USERS = new ArrayList<String>();
    }

}
