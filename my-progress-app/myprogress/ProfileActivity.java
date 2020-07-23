package com.example.myprogress;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final EditText percentPunt = (EditText) findViewById(R.id.editTextPercent);
        final EditText doelPunt = (EditText) findViewById(R.id.editTextDoelpunten);
        final TextView email = (TextView) findViewById(R.id.textViewEmail);
        final TextView study = (TextView) findViewById(R.id.textViewStudy);
        //Intent in = getIntent();
//    String punt = in.getExtras().getString("PUNT");
//        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//        BackEnd.getProgress(BackEnd.USER_NAME);

//        String type = "getProgress";
//        BackEnd Conn = new BackEnd(ProfileActivity.this);
//        Conn.execute(type,BackEnd.USER_NAME);

//        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//        BackEnd.getProgress(BackEnd.USER_NAME);
//        String APP_USER_PERSENTAGE = SharedPrefManager.getInstance(this).getPercentage();
//        String APP_USER_GOAL_POINT = SharedPrefManager.getInstance(this).getGoalPoint();

//        String APP_USER_PERSENTAGE = BackEnd.PERCENT;
//        String APP_USER_GOAL_POINT = BackEnd.GOAL_POINT;
//        String APP_USER_EMAIL = BackEnd.USER_EMAIL;
//        String APP_USER_STUDY = BackEnd.USER_STUDY;

        final String APP_USER = SharedPrefManager.getInstance(this).getUsername();

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getProgress(String.valueOf(APP_USER));

        String APP_USER_PERSENTAGE = SharedPrefManager.getInstance(this).getPercentage();
        String APP_USER_GOAL_POINT = SharedPrefManager.getInstance(this).getGoalPoint();
        String APP_USER_EMAIL = SharedPrefManager.getInstance(this).getEmail();
        String APP_USER_STUDY = SharedPrefManager.getInstance(this).getStudy();

        percentPunt.setText(APP_USER_PERSENTAGE);
        doelPunt.setText(APP_USER_GOAL_POINT);
        email.setText(APP_USER_EMAIL);
        study.setText(APP_USER_STUDY);

//        Log.d("ProfileActivity percent",BackEnd.PERCENT);
//        percentPunt.setText((BackEnd.PERCENT));
//        doelPunt.setText((BackEnd.GOAL_POINT));
//        email.setText((BackEnd.USER_EMAIL));
//        study.setText((BackEnd.USER_STUDY));

    }



}
