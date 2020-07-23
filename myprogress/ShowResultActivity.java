package com.example.myprogress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ShowResultActivity extends AppCompatActivity {

    public static String USER_NAME;
    public static String PRESENTIE;
    public static String DISCUSSIE;
    public static String BRIEF;
    public static String ARTIKEL;
    public static String LEES;
    public static double EINDCIJFER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


//        Intent in = getIntent();
//        USER_NAME = in.getExtras().getString("USER_NAME");
        final EditText presentie = (EditText) findViewById(R.id.editTextPresentie);
        final EditText discussie = (EditText) findViewById(R.id.editTextDiscussie);
        final EditText brief = (EditText) findViewById(R.id.editTextBrief);
        final EditText artikel = (EditText) findViewById(R.id.editTextArtikel);
        final EditText lees = (EditText) findViewById(R.id.editTextLees);
        final EditText eindcijfer = (EditText) findViewById(R.id.editTextEindCijfer);

//        String type = "getGrades";
//        BackEnd Conn = new BackEnd(ShowResultActivity.this);
//        Conn.execute(type,BackEnd.USER_NAME);

//        String CMS_USERNAME = SharedPrefManager.getInstance(this).getCMSUsername();

//        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//        BackEnd.getGrades(CMS_USERNAME);

        String USER_GRADE_P = SharedPrefManager.getInstance(this).loadGradesP();
        String USER_GRADE_D = SharedPrefManager.getInstance(this).loadGradesD();
        String USER_GRADE_B = SharedPrefManager.getInstance(this).loadGradesB();
        String USER_GRADE_A = SharedPrefManager.getInstance(this).loadGradesA();
        String USER_GRADE_L = SharedPrefManager.getInstance(this).loadGradesL();
        String USER_GRADE_E = SharedPrefManager.getInstance(this).loadGradesE();
//        allow nethwork main thread

        //grades are set from the BackEnd
        presentie.setText(USER_GRADE_P);
        discussie.setText(USER_GRADE_D);
        brief.setText(USER_GRADE_B);
        artikel.setText(USER_GRADE_A);
        lees.setText(USER_GRADE_L);
        eindcijfer.setText(USER_GRADE_E);
//        presentie.setText(BackEnd.PRESENTIE);
//        discussie.setText(BackEnd.DISCUSSIE);
//        brief.setText(BackEnd.BRIEF);
//        artikel.setText(BackEnd.ARTIKEL);
//        lees.setText(BackEnd.LEES);
//        eindcijfer.setText(BackEnd.EINDCIJFER);
//eindcijfer.setText(Double.toString(Math.round(EINDCIJFER)));//Math.round() rounds off numbers to a whole number
    }

}
