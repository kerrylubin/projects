package com.example.myprogress;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class UserActivity extends AppCompatActivity {

    AlertDialog.Builder logOutBtnDialog;

    public static boolean isVisible;
    public static String USER_NAME;

    static TextView resultTxt;
    static TextView doelTxt;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        //Main layout ID in your activity_main.xl
        //LinearLayout mainLayout = (LinearLayout) findViewById(R.id.linearLayoutHorizontal);

        isVisible = true;

        //here you refrence the toolbar which is the activity_user2.xml
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //here you refrence the toolbar which is the activity_user2.xml
//        drawer = findViewById(R.id.drawer_layout);
//        //this sets the menu icon and toggle
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
//                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView Title = (TextView) findViewById(R.id.textViewTitleMain);
        final ImageView results = (ImageView) findViewById(R.id.imageViewResultatenBtn);
        resultTxt = (TextView) findViewById(R.id.textViewResultsTxt);
        doelTxt = (TextView) findViewById(R.id.textViewDoelTxt);

        logOutBtnDialog = new AlertDialog.Builder(this);

//        final ImageView addTask = (ImageView) findViewById(R.id.imageViewAddTaskBtn);
//        final ImageView menu = (ImageView) findViewById(R.id.imageViewMenuBtn);
        final ImageView user = (ImageView) findViewById(R.id.imageViewUserBtn);
        final ImageView goalBtn = (ImageView) findViewById(R.id.imageViewTaskBtn);
        final ImageView logOutBtn = (ImageView) findViewById(R.id.imageViewHomeBtn_cms);
        final String APP_USER = SharedPrefManager.getInstance(this).getUsername();
//        String APP_USER = BackEnd.USER_NAME;
//        String APP_USER_ID = BackEnd.USER_ID;
//        String APP_USER_PERSENTAGE = BackEnd.PERCENT;
//        String APP_USER_GOAL_POINT = BackEnd.GOAL_POINT;
//        String APP_USER_ID = SharedPrefManager.getInstance(this).getUserId();


        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getProgress(String.valueOf(APP_USER));

        final String APP_USER_PERSENTAGE = SharedPrefManager.getInstance(this).getPercentage();
        final String APP_USER_GOAL_POINT = SharedPrefManager.getInstance(this).getGoalPoint();

        Log.d("APP_USER_PERSENTAGE", APP_USER_PERSENTAGE +"APP_USER_GOAL_POINT: " + APP_USER_GOAL_POINT + "APP_USER: "+ APP_USER);
//        String type = "getProgress";
//        BackEnd Conn = new BackEnd(UserActivity.this);
//        Conn.execute(type,BackEnd.USER_NAME);

        Title.setText(APP_USER);

        resultTxt.setText(APP_USER_PERSENTAGE);
        doelTxt.setText(APP_USER_GOAL_POINT);

        onResume();
        onPause();

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dialog();
            }
        });

        goalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goalIntent = new Intent(getApplicationContext(), GoalActivity.class);
                //profileIntent.putExtra("PUNT", BackEnd.USER_NAME);
                startActivity(goalIntent);
            }
        });

        user.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                //profileIntent.putExtra("PUNT", BackEnd.USER_NAME);
                startActivity(profileIntent);
            }
        }));

        // when writing this make sure type new View in the brackets -> (new View) this will autocomplete
        //to the whole method seen under
        results.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent resultsIntent = new Intent(getApplicationContext(), ShowResultActivity.class);
//                resultsIntent.putExtra("USER_NAME", SharedPrefManager.getInstance(this).getUsername());
                startActivity(resultsIntent);

            }
        }));

    }

//    @Override//for the open toggle functions
//    public void onBackPressed(){
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//
//            drawer.closeDrawer(GravityCompat.START);
//        } else{
//            super.onBackPressed();
//        }
//    }
    public void dialog()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        SharedPrefManager.getInstance(UserActivity.this).loggedOut();
                        finish();
//                        System.exit(0);
//                        Intent intent = new Intent(UserActivity.this,
//                                LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        startActivity(intent);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE://No button clicked
                        break;
                }
            }
        };
        logOutBtnDialog.setMessage("Are you sure you want to log out?").setTitle("Alert")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).create().show();


    }

    @Override
    protected void onResume()
    {
        super.onResume();
//        resultTxt.setText(BackEnd.PERCENT);
//        doelTxt.setText(BackEnd.GOAL_POINT);
        resultTxt.setText(SharedPrefManager.getInstance(this).getPercentage());
        doelTxt.setText(SharedPrefManager.getInstance(this).getGoalPoint());

        isVisible = true;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        isVisible = false;
    }
}
