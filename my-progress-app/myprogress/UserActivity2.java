package com.example.myprogress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class UserActivity2 extends AppCompatActivity {

    public static boolean isVisible;
    public static String USER_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isVisible = true;

        final TextView Title = (TextView) findViewById(R.id.textViewTitleMain);
        final ImageView results = (ImageView) findViewById(R.id.imageViewResultatenBtn);
//        final ImageView menu = (ImageView) findViewById(R.id.imageViewMenuBtn);
        final ImageView user = (ImageView) findViewById(R.id.imageViewUserBtn);
//        final ImageView task = (ImageView) findViewById(R.id.imageViewTaskBtn);
//        final ImageView addTask = (ImageView) findViewById(R.id.imageViewAddTaskBtn);

        onResume();

        onPause();

        //When the login is the mainActivity un comment this
//        if (isVisible == true)
//        {
//            Intent in = getIntent();
//            USER_NAME = in.getExtras().getString("USER_NAME");
            Title.setText(BackEnd.USER_NAME);

        //}


        // when writing this make sure type new View in the brackets -> (new View) this will autocomplete
        //to the whole method seen under
        results.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent resultsIntent = new Intent(getApplicationContext(), ShowResultActivity.class);
                resultsIntent.putExtra("USER_NAME", BackEnd.USER_NAME);
                startActivity(resultsIntent);

            }
        }));

        final ImageView homeBtn = (ImageView) findViewById(R.id.imageViewHomeBtn_cms);


        homeBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent resultsIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(resultsIntent);

            }
        }));

        // when writing this make sure type new View in the brackets -> (new View) this will autocomplete
        //to the whole method seen under
//        menu.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Intent is saying to android "this is what we want to have happen"
//                //here it wants to open ResultsActivity.class
//                Intent menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
//                startActivity(menuIntent);
//
//            }
//        }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }
}
