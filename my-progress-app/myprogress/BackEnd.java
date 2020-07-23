package com.example.myprogress;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackEnd extends AsyncTask<String,Void,String> {

    static Context context;

    AlertDialog alertDialog;

    public static String USER_NAME;
    public static ArrayList<String> USERS = new ArrayList<String>();
    public static ArrayList<String> USER_GOAL = new ArrayList<String>();
    public static ArrayList<String> USER_GOAL_ID = new ArrayList<String>();
//    public static String USER_GOAL_ID;
    public static String USER_ID;
    public static String USER_STUDY;
    public static  String USER_EMAIL;
    public static String USER_TYPE;
    public static String PRESENTIE;
    public static String DISCUSSIE;
    public static String BRIEF;
    public static String ARTIKEL;
    public static String LEES;
    public static String EINDCIJFER;
    public static String PERCENT;
    public static String GOAL_POINT;
    public static  String TASK;

    static String login_url = "https://"+ DBStrings.DB_HOST +"/login.php";
    static String insert_grades_url = "https://"+ DBStrings.DB_HOST +"/updateGrades.php";
    static String get_grades = "https://"+ DBStrings.DB_HOST +"/getGrades.php";
    static String get_progress = "https://"+ DBStrings.DB_HOST +"/getProgress.php";
    static String get_students_url = "https://"+ DBStrings.DB_HOST + "/get_users.php";
    static String register_url = "https://"+ DBStrings.DB_HOST +"/register2.php";
    static String get_goals_url = "https://"+ DBStrings.DB_HOST +"/get_goals.php";
    static String drop_url = "https://"+ DBStrings.DB_HOST +"/drop_goals.php";
    static String insert_goals_url = "https://"+ DBStrings.DB_HOST +"/insert_goals2.php";

//    static String login_url = "http://"+ DBStrings.DB_HOST +"/login.php";
//    static String insert_grades_url = "http://"+ DBStrings.DB_HOST +"/updateGrades.php";
//    static String get_grades = "http://"+ DBStrings.DB_HOST +"/getGrades.php";
//    static String get_progress = "http://"+ DBStrings.DB_HOST +"/getProgress.php";
//    static String get_students_url = "http://"+ DBStrings.DB_HOST + "/get_users.php";
//    static String register_url = "http://"+ DBStrings.DB_HOST +"/register2.php";
//    static String get_goals_url = "http://"+ DBStrings.DB_HOST +"/get_goals.php";
//    static String drop_url = "http://"+ DBStrings.DB_HOST +"/drop_goals.php";
//    static String insert_goals_url = "http://"+ DBStrings.DB_HOST +"/insert_goals2.php";

    public static String result = null;
    public static String msg = null;
    public static String line = null;
    public static String type = null;

    public static InputStream inputStream;
    public static OutputStream outputStream;

    BackEnd(Context ctx){

        context = (Context) ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        type = voids[0];
        if(type.equals("login"))
        {
            login(voids[1],voids[2]);
            //return result;
        }
        else if(type.equals("Update Grades"))
        {
            updateGrades(voids[1],voids[2], voids[3], voids[4], voids[5], voids[6], voids[7], voids[8]);
            //return result;

        }
        else if(type.equals("getGrades"))
        {
            getGrades(voids[1]);
            //return result;

        }
        else if(type.equals(("getStudents")))
        {
            getStudents();
            //return result;

        }
        else if(type.equals(("register")))
        {
            register(voids[1],voids[2],voids[3],voids[4],voids[5]);
            //return result;
        }
        else if(type.equals(("getProgress")))
        {
            getProgress(voids[1]);
            //return result;
        }
        else if(type.equals(("getGoals")))
        {
            getGoals(voids[1]);
            //return result;
        }
        else if(type.equals(("insertGoals")))
        {
            insertGoals(voids[1], Integer.parseInt(voids[2]),voids[3]);
            //return result;
        }
        else if(type.equals(("dropGoals")))
        {
            dropGoals(voids[1], voids[2],voids[3]);
            //return result;
        }

        return null;
    }

    public static  void login(String em,String pw)
    {
        String email = em;
        String password = pw;

        try
        {
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            Log.d("bufferedWriter:", String.valueOf(bufferedWriter));


            //data that is sending to server
            String post_data = URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8") + "&" +
                    URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");
            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            //getting data from database PHP
            try
            {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();

                    if(result.equals("Login Failed"))//if login failed do this
                    {
                        msg = result;
                        result = null;
                        //Log.d("Backend result failed", result);
                        return;
                    }
                    else
                    {
                        msg = null;
                    }
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("error","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //parsing the json array
            try
            {
                Log.d("RESULT", String.valueOf(result));
                JSONArray jsonArray = new JSONArray(result);
                Log.d("RESULT", String.valueOf(jsonArray));
                //after retreving results it does to much in the background

                for (int i = 0; i <jsonArray.length(); i ++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    //to make this more secure make vars here and store them in sharedpref

                    USER_TYPE = jsonObject.getString("user_type");
                    USER_NAME = jsonObject.getString("users");
                    USER_ID = jsonObject.getString("id");
                    USER_EMAIL = jsonObject.getString("email");
                    USER_STUDY = jsonObject.getString("user_study");

                    if(USER_TYPE.equals(("Student")))
                    {
                        result = "Welcome " + USER_NAME;

                        PRESENTIE = jsonObject.getString("presentatie");
                        DISCUSSIE = jsonObject.getString("discussie");
                        BRIEF = jsonObject.getString("brief");
                        ARTIKEL = jsonObject.getString("artikel");
                        LEES = jsonObject.getString("lees");
                        EINDCIJFER = jsonObject.getString("eindcijfer");

                        PERCENT = jsonObject.getString("user_grade_percentage");

                        if(PERCENT.isEmpty())
                        {
                            PERCENT = "0%";
                        }

                        GOAL_POINT = jsonObject.getString("goal_point");

                        SharedPrefManager.getInstance(BackEnd.context).userLogin(USER_ID,USER_NAME,USER_EMAIL,USER_STUDY,
                                PRESENTIE, DISCUSSIE, BRIEF, ARTIKEL, LEES, EINDCIJFER, PERCENT, GOAL_POINT);

                        Intent Main = new Intent(context, UserActivity.class);
                        //this avoids returning to previous user who logged in before
//                        Main.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        Main.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        Main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(Main);
                        //this prevents users from going back to the loginActivity
                        ActivityCompat.finishAffinity( (Activity) context);
//                        //sending data to the activity
//                        Intent Main = new Intent(context, UserActivity.class);
//                        //Main.putExtra("USER_NAME", USER_NAME);
//                        context.startActivity(Main);//sends the userNAme
                    }
                    else if(USER_TYPE.equals(("Leraar")))
                    {
                        result = "Welcome " + USER_NAME;

                        SharedPrefManager.getInstance(BackEnd.context).userCMSLogin(USER_ID,USER_NAME,USER_EMAIL);
                        //sending data to the activity
                        Intent CMS = new Intent(context, CMSActivity.class);
//                        CMS.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        CMS.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

//                        CMS.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(CMS);//sends the userNAme
                        //this prevents users from going back to the loginActivity
                        ActivityCompat.finishAffinity( (Activity) context);
                    }
//                    USER_GOAL.add(jsonObject.getString("user_goals"));
//                    Log.d("USER_GOAL", String.valueOf(USER_GOAL));
//
////                    USER_GOAL_ID = jsonObject.getString("goal_id");
//                    USER_GOAL_ID.add(jsonObject.getString("goal_id"));
//                    Log.d("USER_GOAL_ID", String.valueOf(USER_GOAL_ID));
                }
            } catch (JSONException e) {
                Log.d("Json error", String.valueOf(e));
                e.printStackTrace();
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            result = "No Connection";
            msg = null;
            e.printStackTrace();
        }
//        msg = null;

    }

    public static void register(String un, String em, String st, String pw,String ut)
    {
        String user_name = un;
        String email = em;
        String password = pw;
        String user_type = ut;
        String user_study = st;

        try {
            URL url = new URL(register_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            //sending to server
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("user_name","UTF-8") + "=" + URLEncoder.encode(user_name,"UTF-8") + "&" +
                    URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8") + "&" +
                    URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8") + "&" +
                    URLEncoder.encode("user_type","UTF-8") + "=" + URLEncoder.encode(user_type,"UTF-8") + "&" +
                    URLEncoder.encode("user_study","UTF-8") + "=" + URLEncoder.encode(user_study,"UTF-8");;

            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            while( (line = bufferedReader.readLine()) != null)
            {
                result = line;

                if(result.equals("Registration successfull!"))//if login failed do this
                {
//                    msg = result;
//                    result = null;

                    Intent login = new Intent(context, LoginActivity.class);
                    context.startActivity(login);//sends the userNAme

                    //Log.d("Backend result failed", result);
                    return;
                }
                else
                {
                    msg = null;
                }
                Log.d("result",result);
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            msg = null;
            //return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getStudents()//this display grades from one student
    {
        try {
            //here is the method it will be sent to the server
            URL url = new URL(get_students_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

        }catch (Exception e) {
            e.printStackTrace();
            Log.e("e","e" + e.getMessage());
        }

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer("");

            while( (line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append((line));
                result = stringBuffer.toString();

                if(result.equals("No Data"))//if login failed do this
                {
                    msg = result;
                    Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                    result = null;
                    //Log.d("Backend result failed", result);
                    return;
                }
                else
                {
                    msg = null;
                }
            }

            bufferedReader.close();
            inputStream.close();
            //httpURLConnection.disconnect();

            //return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("e","e" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONArray jsonArray = new JSONArray(result);
            Log.d("Jsonresult", String.valueOf(jsonArray));

            for (int i = 0; i <jsonArray.length(); i ++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                USERS.add(jsonObject.getString("students"));
                Log.d("Students", String.valueOf(USERS));
                result = null;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        msg = null;

    }

    public static  void getGrades(String app_user)
    {

        String user_name = app_user;

        try {

            URL url = new URL(get_grades);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("user_name","UTF-8") + "=" + URLEncoder.encode(user_name,"UTF-8");
            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            try//reading the data from sql
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();

                    if(result.equals("Geen Cijfers"))//if login failed do this
                    {
                        msg = result;
                        Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        result = null;
                        //Log.d("Backend result failed", result);
                        return;
                    }
                    else
                    {
                        msg = null;
                    }
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                //return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("e","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jsonArray = new JSONArray(result);
                Log.d(" GET GRAGES RESULT", String.valueOf(jsonArray));

                for (int i = 0; i < jsonArray.length(); i ++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);


                    USER_NAME = jsonObject.getString("student_name");
                    PRESENTIE = jsonObject.getString("presentatie");
                    DISCUSSIE = jsonObject.getString("discussie");
                    BRIEF = jsonObject.getString("brief");
                    ARTIKEL = jsonObject.getString("artikel");
                    LEES = jsonObject.getString("lees");
                    EINDCIJFER = jsonObject.getString("eindcijfer");
                    Log.d("p",PRESENTIE);

                    SharedPrefManager.getInstance(BackEnd.context).saveGrades(PRESENTIE,DISCUSSIE,BRIEF,ARTIKEL,LEES,EINDCIJFER);
                }
                //result = null;

            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void updateGrades(String p, String d, String b, String a, String l, String ec, String perc, String s)
    {
        String presentie = p;
        String discussie = d;
        String brief = b;
        String artikel = a;
        String lees = l;
        String eindcijfer = ec;
        String percentage = perc;
        String student = s;


        try {

            //this is the data that will be past trough
            //here is the method it will be sent to the server
            URL url = new URL(insert_grades_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //here is the data that will be sent your post request
            String post_data = URLEncoder.encode("presentatie","UTF-8") + "=" + URLEncoder.encode(presentie,"UTF-8") + "&" +
                    URLEncoder.encode("discussie","UTF-8") + "=" + URLEncoder.encode(discussie,"UTF-8") + "&" +
                    URLEncoder.encode("brief","UTF-8") + "=" + URLEncoder.encode(brief,"UTF-8") + "&" +
                    URLEncoder.encode("artikel","UTF-8") + "=" + URLEncoder.encode(artikel,"UTF-8") + "&" +
                    URLEncoder.encode("lees","UTF-8") + "=" + URLEncoder.encode(lees,"UTF-8") + "&" +
                    URLEncoder.encode("eindcijfer","UTF-8") + "=" + URLEncoder.encode(eindcijfer,"UTF-8") + "&" +
                    URLEncoder.encode("percentage","UTF-8") + "=" + URLEncoder.encode(percentage,"UTF-8") + "&" +
                    URLEncoder.encode("student_name","UTF-8") + "=" + URLEncoder.encode(student,"UTF-8");

            //here is where the conn is closed
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            while( (line = bufferedReader.readLine()) != null)
            {
                result = line;
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();


            //return result;
            msg = null;

        } catch (MalformedURLException e) {
            Writer writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String error = writer.toString();
            Toast.makeText(context.getApplicationContext(), error, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void getGoals(String user_Id)
    {
        String user_id = user_Id;

        try {

            URL url = new URL(get_goals_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("user_id","UTF-8") + "=" + URLEncoder.encode(String.valueOf(user_id),"UTF-8");
            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            try//reading the data from sql
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();

                    if(result.equals("No Data"))//if login failed do this
                    {
                        msg = result;
                        //Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                        result = null;
                        return;
                    }
                    else
                    {
                        msg = null;
                    }
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();



            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("e","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jsonArray = new JSONArray(result);
                Log.d("RESULT", String.valueOf(jsonArray));

                for (int i = 0; i < jsonArray.length(); i ++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    USER_ID = jsonObject.getString("id");
                    USER_GOAL.add(jsonObject.getString("user_goals"));
                    Log.d("USER_GOAL", String.valueOf(USER_GOAL));

//                    USER_GOAL_ID = jsonObject.getString("goal_id");
                    USER_GOAL_ID.add(jsonObject.getString("goal_id"));
                    Log.d("USER_GOAL_ID", String.valueOf(USER_GOAL_ID));

                    SharedPrefManager.getInstance(BackEnd.context).saveGoals(USER_GOAL);

                    SharedPrefManager.getInstance(BackEnd.context).saveGoalId(USER_GOAL_ID);


//                    ArrayList<String> p = SharedPrefManager.getInstance(BackEnd.context).loaduserGoals();
//                    Log.d("SharedPrefManager USER_GOAL", String.valueOf(p));

                }

                //
            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return result;
    }


    public static  void dropGoals(String app_user ,String goalId, String goal_point)
    {
        String user_name = app_user;
        String goal_points = goal_point;
        String goal_id = goalId;

        try {

            URL url = new URL(drop_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("goal_id","UTF-8") + "=" + URLEncoder.encode(goal_id,"UTF-8") + "&" +
                    URLEncoder.encode("goal_point","UTF-8") + "=" + URLEncoder.encode(goal_points,"UTF-8")  + "&" +
                    URLEncoder.encode("user_name","UTF-8") + "=" + URLEncoder.encode(user_name,"UTF-8");

            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            try//reading the data from sql
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                //return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("e","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static  void insertGoals(String userId, int goalId, String text)
    {
        String goal_id = String.valueOf(goalId);
        String goal_text = text;
        String user_id = userId;

        try {

            URL url = new URL(insert_goals_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("goal_id","UTF-8") + "=" + URLEncoder.encode(goal_id,"UTF-8") + "&" +
                    URLEncoder.encode("goal_text","UTF-8") + "=" + URLEncoder.encode(goal_text,"UTF-8") + "&" +
                    URLEncoder.encode("user_id","UTF-8") + "=" + URLEncoder.encode(user_id,"UTF-8");

            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            try//reading the data from sql
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();
                    Log.d("RESULTS",result);
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

//                result = null;
                msg = null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("e","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static  void getProgress(String sn)
    {
        String student_name = sn;

        try {

            URL url = new URL(get_progress);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            //sending to server
            outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            //data that is sending to server
            String post_data = URLEncoder.encode("student_name","UTF-8") + "=" + URLEncoder.encode(student_name,"UTF-8");
            //closing conn
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            inputStream = httpURLConnection.getInputStream();

            try//reading the data from sql
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer("");

                while( (line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append((line));
                    result = stringBuffer.toString();
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                //return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("e","e" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jsonArray = new JSONArray(result);
                Log.d("Backen RESULT", String.valueOf(jsonArray));

                for (int i = 0; i < jsonArray.length(); i ++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    PERCENT = jsonObject.getString("user_grade_percentage");

                    if(PERCENT.isEmpty())
                    {
                        PERCENT = "0%";
                    }
                    GOAL_POINT = jsonObject.getString("goal_point");

//                    SharedPrefManager.getInstance(BackEnd.context).saveProgress(PERCENT,GOAL_POINT);

                }
                result = null;

            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String aVoid) {

        if (msg != null)
        {
            alertDialog.setMessage(msg);
            alertDialog.show();
        }

        if (result != null)
        {
            Toast.makeText(context.getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }
}
