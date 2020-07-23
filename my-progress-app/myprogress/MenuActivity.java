package com.example.myprogress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ImageView NL = (ImageView) findViewById(R.id.imageViewNLBtn);
        // when writing this make sure type new View in the brackets -> (new View) this will autocomplete
        //to the whole method seen under
        NL.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent is saying to android "this is what we want to have happen"
                //here it wants to open ResultsActivity.class
                Intent NL = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(NL);

            }
        }));
    }
}
