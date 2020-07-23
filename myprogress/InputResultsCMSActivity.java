package com.example.myprogress;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputResultsCMSActivity extends AppCompatActivity {

    public static String USER_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final TextView Title = (TextView) findViewById(R.id.textViewResult);
        final EditText presentie = (EditText) findViewById(R.id.editTextPresentie_cms);
        final EditText discussie = (EditText) findViewById(R.id.editTextDiscussie_cms);
        final EditText brief = (EditText) findViewById(R.id.editTextBrief_cms);
        final EditText artikel = (EditText) findViewById(R.id.editTextArtikel_cms);
        final EditText lees = (EditText) findViewById(R.id.editTextLees_cms);
        final EditText eindcijfer = (EditText) findViewById(R.id.editTextEindCijfer_cms);

        final Button saveBtn = (Button) findViewById(R.id.buttonCmsSave);
        final Button editBtn = (Button) findViewById(R.id.buttonEditCms);

        Intent in = getIntent();
        USER_NAME = in.getExtras().getString("USER_NAME");
        Log.d("GET GRADES USERNAME: ", USER_NAME);
        Title.setText(USER_NAME);

        //here student grade will be shown depending on which student is clicked
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getGrades(USER_NAME);

        String USER_GRADE_P = SharedPrefManager.getInstance(this).loadGradesP();
        String USER_GRADE_D = SharedPrefManager.getInstance(this).loadGradesD();
        String USER_GRADE_B = SharedPrefManager.getInstance(this).loadGradesB();
        String USER_GRADE_A = SharedPrefManager.getInstance(this).loadGradesA();
        String USER_GRADE_L = SharedPrefManager.getInstance(this).loadGradesL();
        String USER_GRADE_E = SharedPrefManager.getInstance(this).loadGradesE();
//        String USER_GRADE_P = BackEnd.PRESENTIE;
//        String USER_GRADE_D = BackEnd.DISCUSSIE;
//        String USER_GRADE_B = BackEnd.BRIEF;
//        String USER_GRADE_A = BackEnd.ARTIKEL;
//        String USER_GRADE_L = BackEnd.LEES;
//        String USER_GRADE_E = BackEnd.EINDCIJFER;
        presentie.setText(USER_GRADE_P);
        discussie.setText(USER_GRADE_D);
        brief.setText(USER_GRADE_B);
        artikel.setText(USER_GRADE_A);
        lees.setText(USER_GRADE_L);
        eindcijfer.setText(USER_GRADE_E);

        editBtn.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentie.setFocusableInTouchMode(true);//this makes it editable
                discussie.setFocusableInTouchMode(true);
                brief.setFocusableInTouchMode(true);
                artikel.setFocusableInTouchMode(true);
                lees.setFocusableInTouchMode(true);
                eindcijfer.setFocusable(false);
            }
        }));

        //this saves what you have edited
        saveBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String New_PRESENTIE = presentie.getText().toString();
                String New_DISCUSSIE = discussie.getText().toString();
                String New_BRIEF = brief.getText().toString();
                String New_ARTIKEL = artikel.getText().toString();
                String New_LEES = lees.getText().toString();

                Double vakken[] = {Double.parseDouble(New_PRESENTIE), Double.parseDouble(New_DISCUSSIE) ,
                        Double.parseDouble(New_BRIEF) , Double.parseDouble(New_ARTIKEL)
                        , Double.parseDouble(New_LEES) };

                String New_EINDCIJFER = calculateEindcijfer(vakken,New_PRESENTIE,New_DISCUSSIE,New_BRIEF,New_ARTIKEL,New_LEES);

                presentie.setText(New_PRESENTIE);
                discussie.setText(New_DISCUSSIE);
                brief.setText(New_BRIEF);
                artikel.setText(New_ARTIKEL);
                lees.setText(New_LEES);

                String PERCENT = calculatePercentage(vakken);
                Log.d("PERCENTAGE", PERCENT);

                eindcijfer.setText(New_EINDCIJFER);
                presentie.setFocusable(false);
                discussie.setFocusable(false);
                brief.setFocusable(false);
                artikel.setFocusable(false);
                lees.setFocusable(false);
                eindcijfer.setFocusable(false);

                //save to the sql database
//                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//                BackEnd.updateGrades(New_PRESENTIE, New_DISCUSSIE, New_BRIEF, New_ARTIKEL, New_LEES, New_EINDCIJFER, USER_NAME);
                String type = "Update Grades";
                BackEnd Conn = new BackEnd(InputResultsCMSActivity.this);
                Conn.execute(type, New_PRESENTIE, New_DISCUSSIE, New_BRIEF, New_ARTIKEL, New_LEES, New_EINDCIJFER,PERCENT, USER_NAME);
            }
        }));

    }
    //this calculates the eindcijfer
    String calculateEindcijfer(Double vakken[], String p,String d,String b,String a,String l)
    {
        Double VAKKEN [] = vakken;
        String P = p;
        String D = d;
        String B = b;
        String A = a;
        String L = l;
        String eindcijfer;

        //this calculates the eindcijfer
//        Double vakken[] = {Double.parseDouble(P), Double.parseDouble(D) ,
//                Double.parseDouble(B) , Double.parseDouble(A)
//                , Double.parseDouble(L) };

        Double eCijfer = ( Double.valueOf(P) + Double.valueOf(D) +
                Double.valueOf(B) + Double.valueOf(A)
                + Double.valueOf(L) ) / VAKKEN.length ;

        eindcijfer = Double.toString(Math.round(eCijfer));

        return eindcijfer;
    }
    //this is calculates how much percentage the grade are completed
    String calculatePercentage(Double v[]) {

        List<Double> grade_list = new ArrayList<Double>(Arrays.asList(v));//made double array into a list

        Map<Double, Integer> grade_count = new HashMap<>();//this will store how much a grade is repeated

        //this is the algorithm that puts how much times grades are dupplicated in grade_list.
        //these grades will be stored in grade_count
        for (Double student_grade : grade_list)
        //this loops trough the grade_list and gives student_grade its value 1 by 1
        {
            if (grade_count.containsKey(student_grade))
            // if grade_count contain the key student_grade in its list
            // it  will add a value of 1 to its key. showing its only has one duplicate
            {
                grade_count.put(student_grade, grade_count.get(student_grade) + 1);
//                        Log.d("grade_count.get", String.valueOf(grade_count.get(student_grade)));
            }
            else
            {
//                        Log.d("else student_grade", String.valueOf(student_grade));
                grade_count.put(student_grade, 1);
            }
        }

        Integer rest_vak = 0;
        //this loops trough grade_count and gets its values and keys.
        // if the key is 0.0? its value wil be given to a var.
        // that value has the number of time its in grade_list
        // this is used to calculate a percentage
        for ( Map.Entry<Double, Integer > entry : grade_count.entrySet())
        {
            Log.d("Duplicates ",entry.getKey() + " = " + entry.getValue());

            if(entry.getKey() == 0.0)
            {
                rest_vak = entry.getValue();
                Log.d("rest vak: ", String.valueOf(rest_vak));
            }
        }

        int percent = 100 / v.length * ( v.length - rest_vak);
        Log.d("rounded percents", String.valueOf(Math.round(percent)));

        String PERCENT = String.valueOf(Math.round(percent)+"%") ;
//        Log.d("NEW PERCENT", PERCENT);

        return PERCENT;
    }

}
