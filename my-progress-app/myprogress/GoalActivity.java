package com.example.myprogress;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GoalActivity extends AppCompatActivity {

    EditText textIn;
    EditText titleTextIn;
    Button buttonAdd;
    LinearLayout container;
    TextView textOut;
    String goalText;
    AlertDialog.Builder removeBtnDialog;
    int GOAL_ID = -1;
    ArrayList<String> GOAL_AR = new ArrayList<String>();
    Map<Integer, String> GOALS = new HashMap<Integer, String>();
    public  int GOAL_POINTS = 0;
    static String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

       final String APP_USER = SharedPrefManager.getInstance(this).getUsername();

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getProgress(String.valueOf(APP_USER));


        final String APP_USER_ID = SharedPrefManager.getInstance(this).getUserId();
        final String USER_GOAL_POINT = SharedPrefManager.getInstance(this).getGoalPoint();
//        String APP_USER = BackEnd.USER_NAME;
//        String APP_USER_ID = BackEnd.USER_ID;
//        Integer USER_GOAL_POINT = Integer.parseInt(BackEnd.GOAL_POINT);
        Log.d("APP_USER", String.valueOf(APP_USER) +"APP_USER_ID: " + String.valueOf(APP_USER_ID) + "USER_GOAL_POINT: "+ USER_GOAL_POINT);
//        type = "getProgress";
//        BackEnd Conn = new BackEnd(GoalActivity.this);
//        Conn.execute(type,BackEnd.USER_NAME);

//        GOAL_POINTS = Integer.parseInt(SharedPrefManager.getInstance(this).getGoalPoint());
        GOAL_POINTS = Integer.parseInt(USER_GOAL_POINT);

        removeBtnDialog = new AlertDialog.Builder(this);

        textIn = (EditText)findViewById(R.id.textin);

        buttonAdd = (Button)findViewById(R.id.add);

        container = (LinearLayout)findViewById(R.id.container);

        final LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        BackEnd.getGoals(APP_USER_ID);

//        type = "getGoals";//this version dont work to well still needs to fing out why
//        BackEnd Conn_Goals = new BackEnd(GoalActivity.this);
//        Conn_Goals.execute(type,BackEnd.USER_ID);
//        Log.d("VALUE", String.valueOf(BackEnd.USER_GOAL));
        if( BackEnd.USER_GOAL_ID == null)
//        if( SharedPrefManager.getInstance(this).getUserGoalId() == null)
        {
            GOAL_ID = 0;
        }
        else
        {
            String user_goal = "";

            for (int i = 0; i < BackEnd.USER_GOAL.size();i++)
//            for (int i = 0; i < SharedPrefManager.getInstance(this).getUserGoal().size();i++)

                {//had error with getting all tha data to display

                GOAL_ID = Integer.parseInt(BackEnd.USER_GOAL_ID.get(i));

                user_goal = BackEnd.USER_GOAL.get(i);
                Log.d("user goals length", String.valueOf(BackEnd.USER_GOAL.size()));
                //goal_list = new ArrayList<String>(Arrays.asList(BackEnd.USER_GOAL.get(i)));
                Integer goal_id = Integer.parseInt(BackEnd.USER_GOAL_ID.get(i));
                GOALS.put(goal_id,user_goal);
                Log.d("goals array", String.valueOf(GOALS));
                Log.d("goals length", String.valueOf(GOALS.size()));

                if (GOALS.size() == 5)
                {
                    Toast.makeText(getApplicationContext(), "Maximun Doel", Toast.LENGTH_LONG).show();
                    buttonAdd.setEnabled(false);
                    textIn.setText("");
                }

                final View goalView = layoutInflater.inflate(R.layout.row, null);

                textOut = (TextView) goalView.findViewById(R.id.textout);

//                final Button buttonRemove = (Button ) goalView.findViewById(R.id.remove);


                if(user_goal != "null")
                {

                    textOut.setText(user_goal);

                    setRemoveBtnId(GOAL_ID,goalView,textOut,APP_USER,USER_GOAL_POINT);

                    container.addView(goalView);
                }//ad an if statement if the child has a parent add it to the view by how many
                //elemts in the array
            }

        }

        buttonAdd.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                GOAL_ID++;

                final View goalView = layoutInflater.inflate(R.layout.row, null);

                textOut = (TextView) goalView.findViewById(R.id.textout);

                goalText = textIn.getText().toString();

                textOut.setText(goalText);

                if(goalText.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Text invoeren", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //GOAL_AR.add(goalText);//text added to array
                    GOALS.put(GOAL_ID, goalText);
                    //save goals and goalid to sharedPrefrences

                    textIn.setText("");
                    Log.d("Goal_AR", String.valueOf(GOALS) +"ID: " + String.valueOf(GOAL_ID) + "Length: "+ GOALS.size());
                    //Log.d("size of array: ",String.valueOf(getArSize()));

                    //always add StrictMode or outputStream
//                    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//                    BackEnd.insertGoals(BackEnd.USER_ID,GOAL_ID, goalText);

                    //goals aresaved directly to the database once it gets the goal id and user id from the shared pref
                    type = "insertGoals";
                    BackEnd Conn_insert = new BackEnd(GoalActivity.this);
                    Conn_insert.execute(type,APP_USER_ID, String.valueOf(GOAL_ID), goalText);
//                    Conn_insert.execute(type,BackEnd.USER_ID, String.valueOf(GOAL_ID), goalText);

                    if (GOALS.size() == 5)
                    {
                        Toast.makeText(getApplicationContext(), "Maximun Doel", Toast.LENGTH_LONG).show();
                        buttonAdd.setEnabled(false);
                        textIn.setText("");
                    }

                    //this needs to change to the textout
//                    final Button buttonRemove = (Button) goalView.findViewById(R.id.remove);

                    setRemoveBtnId(GOAL_ID,goalView,textOut,APP_USER,USER_GOAL_POINT);

                    container.addView(goalView);
                }
            }
        });
    }


    public void setRemoveBtnId(final int ID, final View v, TextView tv, String user, String user_goalpoint)
    {
        final View addView = v;
        final int id = ID;
        final TextView goalText = tv;
        final String USER_GOAL_POINT = user_goalpoint;
        final String APP_USER = user;

            goalText.setId(id);
            Log.d("removeBtn ID:", String.valueOf(id));

        goalText.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(final View v) {
                buttonAdd.setEnabled(true);
                Log.d("removeBtn", String.valueOf(v.getId()));

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                //goalText.setId(getArSize());

                                //GOAL_AR.remove((v.getId()));// new index needs to be passed here button id needs to be reset
                                GOALS.remove(v.getId());
                                Log.d("goal array: ", String.valueOf(GOALS) +" goalText ID: " + goalText.getId() + " array Length: "+ GOAL_AR.size());
                                ((LinearLayout)addView.getParent()).removeView(addView);//remove from view
                                GOAL_POINTS++;

                                //always add StrictMode or outputStream
//                                    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
//                                    BackEnd.dropGoals(BackEnd.USER_NAME,String.valueOf(goalText.getId()), String.valueOf(GOAL_POINTS));//remove column
//                                    Log.d("goalText ID: ",String.valueOf(goalText.getId()));

                                type = "dropGoals";
                                BackEnd Conn_drop = new BackEnd(GoalActivity.this);
                                Conn_drop.execute(type,APP_USER,String.valueOf(goalText.getId()), String.valueOf(GOAL_POINTS));
                                //change the value in sharedpreferences
                                SharedPrefManager.getInstance(GoalActivity.this).saveNewProgress(String.valueOf(GOAL_POINTS));
                                //BackEnd.GOAL_POINT = String.valueOf(GOAL_POINTS);//goal points gets the new value
                                Log.d("GoalActivty GOAL_POINTS", String.valueOf(GOAL_POINTS));


                                if (GOALS.size() == 0)
                                {
                                    GOAL_ID = -1;
                                }
                                break;

                            case DialogInterface.BUTTON_NEGATIVE://No button clicked
                                break;
                        }
                    }
                };
                removeBtnDialog.setMessage("Ben je zeker deze doel is klaar?").setTitle("Alert")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).create().show();

                return false;
            }
        });

//        goalText.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(final View v)
//            {
//                buttonAdd.setEnabled(true);
//                Log.d("removeBtn", String.valueOf(v.getId()));
//
//                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case DialogInterface.BUTTON_POSITIVE:
//                                //Yes button clicked
//                                //goalText.setId(getArSize());
//
//                                //GOAL_AR.remove((v.getId()));// new index needs to be passed here button id needs to be reset
//                                GOALS.remove(v.getId());
//                                Log.d("goal array: ", String.valueOf(GOALS) +" goalText ID: " + goalText.getId() + " array Length: "+ GOAL_AR.size());
//                                ((LinearLayout)addView.getParent()).removeView(addView);//remove from view
//                                GOAL_POINTS++;
//
//                                //always add StrictMode or outputStream
////                                    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
////                                    BackEnd.dropGoals(BackEnd.USER_NAME,String.valueOf(goalText.getId()), String.valueOf(GOAL_POINTS));//remove column
////                                    Log.d("goalText ID: ",String.valueOf(goalText.getId()));
//
//                                type = "dropGoals";
//                                BackEnd Conn_drop = new BackEnd(GoalActivity.this);
//                                Conn_drop.execute(type,APP_USER,String.valueOf(goalText.getId()), String.valueOf(GOAL_POINTS));
//                                //change the value in sharedpreferences
//                                SharedPrefManager.getInstance(GoalActivity.this).saveNewProgress(String.valueOf(GOAL_POINTS));
//                                //BackEnd.GOAL_POINT = String.valueOf(GOAL_POINTS);//goal points gets the new value
//                                Log.d("GoalActivty GOAL_POINTS", String.valueOf(GOAL_POINTS));
//
//
//                                if (GOALS.size() == 0)
//                                {
//                                    GOAL_ID = -1;
//                                }
//                                break;
//
//                                case DialogInterface.BUTTON_NEGATIVE://No button clicked
//                                break;
//                        }
//                    }
//                };
//                removeBtnDialog.setMessage("Ben je zeker deze doel is klaar?").setTitle("Alert")
//                        .setPositiveButton("Yes", dialogClickListener)
//                        .setNegativeButton("No", dialogClickListener).create().show();
//
//            }
//        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //BackEnd.USER_GOAL will have the same elements in the array if you dont set the value to an array
        BackEnd.USER_GOAL = new ArrayList<String>();
        BackEnd.USER_GOAL_ID = new ArrayList<String>();
    }
}
