package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONpractice extends AppCompatActivity {

    private TextView jsonItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_s_o_npractice);

        Button btnHit = (Button) findViewById(R.id.jsonBtn);
        jsonItem = (TextView) findViewById(R.id.jsonItem);

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                //new JsonTask().execute("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json");
            }
        });
    }

    public class JsonTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJSON = buffer.toString();
                JSONObject jsonObject = new JSONObject(finalJSON);
                JSONArray jsonArray = jsonObject.getJSONArray("movies");
                JSONObject finalObject = jsonArray.getJSONObject(0);
                String movieName = finalObject.getString("movie");
                int year = finalObject.getInt("year");

                return movieName + " - " + year;
                //                JSONArray JA = new JSONArray();
//                Log.d(TAG, "doInBackground: " + JA);
//
//                for (int i=0; i<JA.length(); i++){
//                    JSONObject JO = (JSONObject) JA.get(i);
//                    singleParsed = "ID:" + JO.get("id") + "\n" +
//                                "Name:" + JO.get("name") + "\n" +
//                                "Country:" + JO.get("country") + "\n";
//                }
//                dataParsed = dataParsed + singleParsed;
//                Log.d(TAG, "doInBackground: " + dataParsed);
//                return singleParsed;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
            @Override
            protected void onPostExecute (String s){
                super.onPostExecute(s);
                jsonItem.setText(s);
            }
    }
    public void parseJson(View view){
        if(jsonItem != null){

        }
    }
}
