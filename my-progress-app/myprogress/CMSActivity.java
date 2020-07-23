package com.example.myprogress;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CMSActivity extends AppCompatActivity {

    public static boolean isVisible;
    public static String USER_NAME;

    AlertDialog.Builder logOutBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cms);

        if(!SharedPrefManager.getInstance(this).isCMSLoggedIn() ){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        logOutBtnDialog = new AlertDialog.Builder(this);

        final ImageView studentsBtn = (ImageView) findViewById(R.id.imageViewStudentBtn_cms);
        final TextView Title = (TextView) findViewById(R.id.textViewUsername_cms);
        final ImageView logOutBtn = (ImageView) findViewById(R.id.imageViewHomeBtn_cms);

        final String APP_USER = SharedPrefManager.getInstance(this).getCMSUsername();

        Title.setText(APP_USER);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dialog();
            }
        });

        studentsBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent StudentIntent = new Intent(getApplicationContext(), StudentCMSActivity.class);
                startActivity(StudentIntent);
            }
        }));
    }

    public void dialog()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked

                        SharedPrefManager.getInstance(CMSActivity.this).loggedOut();
                        finish();
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
