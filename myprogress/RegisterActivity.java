package com.example.myprogress;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    public static String NAME;
//    public static String USER_NAME;
    public static String PASSWRD;
    public static String RE_PASSWRD;
    public static String BEROEP;
    public static String EMAIL;
    public static String STUDY;
    public static AlertDialog.Builder registerDialog;
    public static DatePickerDialog.OnDateSetListener mDateSetListener;
    public static TextView loginTextView;
    public static Context RegisterContext;

    public static boolean activityVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, UserActivity.class));
            return;
        }

        if(SharedPrefManager.getInstance(this).isCMSLoggedIn() ){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        activityVisible = true;

        final Button registerBtn = (Button) findViewById(R.id.registerBtn);
        final EditText name = (EditText) findViewById(R.id.nameEditText);
//        final EditText uname = (EditText) findViewById(R.id.userNameEditText);
        final EditText email =  (EditText) findViewById(R.id.emailEditText);
        final EditText pass = (EditText) findViewById(R.id.passEditText);
        final EditText re_pass = (EditText)findViewById(R.id.retypeEditText);
        final Spinner beroep = (Spinner) findViewById(R.id.beroepEditText);
        final EditText study = (EditText) findViewById(R.id.studyEditText);

        //registerBtn.setEnabled(false);

        final String[] items = new String[]{"Kies een Beroep","Student", "Leraar"};

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        beroep.setAdapter(adapter);

        RegisterContext = getApplicationContext();

        loginTextView = (TextView) findViewById(R.id.loginTextView);

        //to make an alert box start with this you pass the context
        registerDialog = new AlertDialog.Builder(RegisterActivity.this);

        //this is the listener that will collect the date from the user and set the date
        //loginIntent onClickListener -> go to login page
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open RegisterActivity.class
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });



        final ArrayList<String> user_data = new ArrayList<String>();

        //BEROEP = bdate.getText().toString();
//                Log.d("fname","firstname "+ fName);
//                Log.d("lname","lastname "+NAME);
//                Log.d("address","addrss " + addrss);
//                Log.d("uname","userN "+ USER_NAME);
//                Log.d("passW","PASSWRD "+ PASSWRD);
//                Log.d("rePass","reP "+ RE_PASSWRD);
//                Log.d("BEROEP","bDay "+ BEROEP);
        //on the register btn click it will take the data that the user entered
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NAME = name.getText().toString();
                PASSWRD = pass.getText().toString();
                BEROEP = beroep.getSelectedItem().toString();
                RE_PASSWRD = re_pass.getText().toString();
                EMAIL = email.getText().toString();
                STUDY = study.getText().toString();

                String user_text = NAME + PASSWRD + BEROEP + EMAIL+ STUDY;

                user_data.add(NAME);
                user_data.add(PASSWRD);
                user_data.add(BEROEP);
                user_data.add(EMAIL);
                user_data.add(STUDY);
                Log.d("user_data", String.valueOf(user_data) + " " + user_data.size());

                //if firstname is Nothing show alert "Add Your Firstname!
//                if(user_data.isEmpty())
//                {
//                    registerDialog.setMessage( "There is no information added!").setTitle("Alert!").setCancelable(true).create().show();
//                }
//                else if(user_data.size() > 1 )
//                {
//                    registerBtn.setEnabled(true);
//                    //registerDialog.setMessage( "Add Your Name!").setTitle("Alert!").setCancelable(true).create().show();
//                }
                if(NAME.equals(""))
                {
                    registerDialog.setMessage( "Add Your Name!").setTitle("Alert!").setCancelable(true).create().show();
                }
                //if password is nothing show alert box "Add a Password"
                else if(PASSWRD.equals(""))
                {
                    registerDialog.setMessage( "Add A Password!").setTitle("Alert!").setCancelable(true).create().show();
                }
                else if(!RE_PASSWRD.equals(PASSWRD))
                {
                    registerDialog.setMessage( "Password is not the same").setTitle("Alert!").setCancelable(true).create().show();
                }
                //if email is nothing show alert box "Add a Password"
                else if(EMAIL.equals(""))
                {
                    registerDialog.setMessage( "Add A Password!").setTitle("Alert!").setCancelable(true).create().show();
                }
                else if(STUDY.equals(""))
                {
                    registerDialog.setMessage( "Add A Study!").setTitle("Alert!").setCancelable(true).create().show();
                }
                //if password is not the same as retype_password show alert box "Retype The Password Again"
                else if(!PASSWRD.equals(RE_PASSWRD))
                {
                    registerDialog.setMessage( "Retype The Password Again!").setTitle("Alert!").setCancelable(true).create().show();
                }
                else if(BEROEP == items[0])
                {
                    registerDialog.setMessage( "Kies een beroep!").setTitle("Alert!").setCancelable(true).create().show();
                }
                else if(user_data.size() >= 5 )
                {
                    String type = "register";
                    BackEnd Conn = new BackEnd(RegisterActivity.this);
                    Conn.execute(type, NAME, EMAIL, STUDY, PASSWRD,BEROEP);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        activityVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityVisible = false;
    }

}
