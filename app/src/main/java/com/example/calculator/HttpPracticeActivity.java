package com.example.calculator;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.calculator.model.LoginResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPracticeActivity extends AsyncTask<String, Void, String> {
    Context context;
    private ProgressDialog progressDialog;
    private LoginInterface loginInterface;

    public static final String TAG = "TAG";
    public HttpPracticeActivity(Context context){
        this.context = context;

    }
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        String result="";
        String username, password;
        username = params[0];
        password = params[1];
        Log.d(TAG, "doInBackground: " + params[0]);
        Log.d(TAG, "doInBackground: "+params[1]);

        try {
            URL url = new URL("http://www.app.powergenltd.com/login.php?user_name=" + username + "&pass_word="+ password);
            urlConnection = (HttpURLConnection) url.openConnection();

            int code = urlConnection.getResponseCode();
            if (code !=  200) {
                throw new IOException("Invalid response from server: " + code);
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result += line;
                Log.d("data: ", line);
            }
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        Gson gson = new Gson();
        LoginResponse loginResponse = gson.fromJson(s, LoginResponse.class);
       // Toast.makeText(context, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
        loginInterface.loginResponse(loginResponse);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("wait");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }
    public interface LoginInterface{
        void loginResponse(LoginResponse response);
    }
    public void loginResponseArrived(LoginInterface loginInterface){
        this.loginInterface = loginInterface;

    }
}
