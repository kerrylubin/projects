package com.example.myprogress;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public static String USER;
    public static String PAX;
    public static AlertDialog.Builder loginDialog;
    public static Context LoginContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //if the username has a variable and return true go to the UserActivity
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, UserActivity.class));
            return;
        }

        if(SharedPrefManager.getInstance(this).isCMSLoggedIn()){
            finish();
            startActivity(new Intent(this, CMSActivity.class));
            return;
        }

        LoginContext = getApplicationContext();

        Button logInBtn = (Button) findViewById(R.id.logInBtnButton);
        final EditText emailAdrress = (EditText) findViewById(R.id.editTextEmail);
        final EditText password = (EditText) findViewById(R.id.editTextPassword);
        final TextView registerTextView = (TextView) findViewById(R.id.registerTextView);

        //to make an alert box start with this you pass the context
        loginDialog = new AlertDialog.Builder(LoginActivity.this);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER = emailAdrress.getText().toString();
                PAX = password.getText().toString();

                String type = "login";
                BackEnd Conn = new BackEnd(LoginActivity.this);
                Conn.execute(type, USER, PAX);
//                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//                BackEnd.login(USER, PAX);
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open RegisterActivity.class
                Intent loginIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
