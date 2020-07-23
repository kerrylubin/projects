package com.example.myprogress;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPrefManager
{
    private static  SharedPrefManager mInstance;
    private static Context mCtx;

    public static String SHARED_PREF_NAME = "mysharedpref12";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_CMS_USERNAME = "CMS_username";
    private static final String KEY_CMS_USER_EMAIL = "userCMS_email";
    private static final String KEY_CMS_USER_ID = "CMS_userid";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_ID = "userid";
    private static final String KEY_USER_PERCENT = "percent";
    private static final String KEY_USER_STUDY = "userstudy";
    private static ArrayList<String> KEY_USER_GOAL = null;
    private static ArrayList<String> KEY_USER_GOALID = null;
//    private static final String KEY_USER_GOAL = "goal";
//    private static final String KEY_USER_GOALID  = "goalid";
    private static final String KEY_USER_GOALPOINT  = "GOALPOINT";
    private static final String KEY_PRESENTIE = "PRESENTIE";
    private static final String KEY_DISCUSSIE = "DISCUSSIE";
    private static final String KEY_BRIEF = "BRIEF";
    private static final String KEY_ARTIKEL = "ARTIKEL";
    private static final String KEY_LEES  = "LEES";
    private static final String KEY_EINDCIJFER  = "EINDCIJFER";

    private SharedPrefManager (Context context){
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){
        if (mInstance == null)
        {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this stores data from the login it recieves from php
    public boolean userLogin(String id, String username,String email, String userstudy, String p,String d,
                             String b, String a,String l, String e,String percent,String usergoalpoint){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_STUDY, userstudy);
        editor.putString(KEY_PRESENTIE, p);
        editor.putString(KEY_DISCUSSIE, d);
        editor.putString(KEY_BRIEF, b);
        editor.putString(KEY_ARTIKEL, a);
        editor.putString(KEY_LEES, l);
        editor.putString(KEY_EINDCIJFER, e);
        editor.putString(KEY_USER_PERCENT, percent);
        editor.putString(KEY_USER_GOALPOINT, usergoalpoint);
//        editor.putString(KEY_USER_GOALID, String.valueOf(user_goal_id));
//        editor.putString(KEY_USER_GOAL, String.valueOf(user_goal));
        editor.apply();

        return true;
    }

    public boolean userCMSLogin(String id, String username,String email){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_CMS_USER_ID, id);
        editor.putString(KEY_CMS_USER_EMAIL, email);
        editor.putString(KEY_CMS_USERNAME, username);
        editor.apply();

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;

        }
        return  false;
    }

    public boolean isCMSLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_CMS_USERNAME, null) != null){
            return true;
        }
        return  false;
    }

    //this stores data from the login it recieves from php
    public boolean saveGrades(String p,String d, String b, String a,String l, String e){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_PRESENTIE, p);
        editor.putString(KEY_DISCUSSIE, d);
        editor.putString(KEY_BRIEF, b);
        editor.putString(KEY_ARTIKEL, a);
        editor.putString(KEY_LEES, l);
        editor.putString(KEY_EINDCIJFER, e);
        editor.apply();

        return true;
    }

    public void saveGoals(ArrayList<String> usergoal){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(String.valueOf(KEY_USER_GOAL), String.valueOf(usergoal));

//        Gson gson = new Gson();
//        String json_usergoals = gson.toJson(KEY_USER_GOAL);

//        editor.putString(json_usergoals, String.valueOf(usergoal));
        Log.d("Sharedpref usergoal ", String.valueOf(KEY_USER_GOAL));

        editor.apply();
    }

    public void saveNewProgress(String usergoalpoint)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString(KEY_USER_GOALPOINT, usergoalpoint);
        editor.apply();
    }

    public void saveGoalId(ArrayList<String>  usergoal_id){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(String.valueOf(KEY_USER_GOALID), String.valueOf(usergoal_id));

        Gson gson = new Gson();
        String json_usergoal_id = gson.toJson(KEY_USER_GOALID);

        editor.putString(json_usergoal_id, String.valueOf(usergoal_id));
        editor.apply();
    }

    public ArrayList<String> loaduserGoals(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json_usergoals = sharedPreferences.getString(String.valueOf("usergoal"), null);

        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        KEY_USER_GOAL = gson.fromJson(json_usergoals, type);

        if (KEY_USER_GOAL == null) {

            StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
            BackEnd.getGoals(BackEnd.USER_ID);


            KEY_USER_GOAL = new ArrayList<>();
        }
        return null;
    }
    public void loaduserGoalId(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json_usergoal_id = sharedPreferences.getString(String.valueOf(KEY_USER_GOALID), null);

        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        KEY_USER_GOALID = gson.fromJson(json_usergoal_id, type);

        if (KEY_USER_GOALID == null) {
            KEY_USER_GOALID = new ArrayList<>();
        }
    }

    public String loadGradesP(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PRESENTIE,null);
    }
    public String loadGradesD(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DISCUSSIE,null);
    }
    public String loadGradesB(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BRIEF,null);
    }
    public String loadGradesA(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ARTIKEL,null);
    }
    public String loadGradesL(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LEES,null);
    }
    public String loadGradesE(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EINDCIJFER,null);
    }
//    public String loaduserGoalId(){
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
//        return sharedPreferences.getString(KEY_USER_GOAL,null);
//    }

//    public String getUserGoalId(){
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
//        return sharedPreferences.getString(KEY_USER_GOALID,null);
//
//    }
    public String getPercentage(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_PERCENT,null);

    }
    public String getGoalPoint(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_GOALPOINT,null);

    }
    public String getStudy(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_STUDY,null);

    }
    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);

    }
    public String getCMSUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CMS_USERNAME,null);

    }
    public String getEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);

    }
    public String getUserId(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ID,null);

    }

    public boolean loggedOut()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
//        ActivityCompat.finishAffinity( (Activity) mCtx);

        Intent intent = new Intent(mCtx, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//addFlags works and but when a goal is entered or deleted it doesn't
        mCtx.startActivity(intent);
//        System.exit(0);

        return  true;
    }

}


