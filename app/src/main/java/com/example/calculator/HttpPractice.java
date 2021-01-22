package com.example.calculator;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPractice extends AsyncTask<String, Void, String> {
    Context context;
    String[] params;
    public static final String TAG = "TAG";
    public HttpPractice(Context context, String[] params){
        this.context = context;
        this.params = params;
        Log.d(TAG, "HttpPractice: "+ params.length);
    }
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        String result="";
        String username, password;
        username = params[0];
        password = params[1];

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
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
