package com.example.calculator.model;

import android.os.AsyncTask;
import android.util.Log;

import com.example.calculator.callbacks.JsonResponseCallback;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonResponse extends AsyncTask<String, String, String> {
    String singleParsed = ""; String dataParsed = "";
    public static final String TAG ="";
    JsonResponseCallback jsonResponseCallback;

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

//            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null) {
                //buffer.append(line);
                dataParsed += line;
            }

//                String finalJSON = buffer.toString();
////                JSONObject jsonObject = new JSONObject(finalJSON);
////                JSONArray jsonArray = jsonObject.getJSONArray("movies");
////                JSONObject finalObject = jsonArray.getJSONObject(0);
////                String movieName = finalObject.getString("movie");
////                int year = finalObject.getInt("year");
//
//               // return movieName + " - " + year;
//                JSONArray jsonArray = new JSONArray(finalJSON);
//
//                for (int i=0; i<jsonArray.length(); i++){
//                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//                    singleParsed = "ID:" + jsonObject.get("ID") + "\n" + "Name:" + jsonObject.get("Name") + "\n" + "Country:" + jsonObject.get("Country") + "\n";
//                    dataParsed = dataParsed + singleParsed;
//                }
            return dataParsed;
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
        Gson gson = new Gson();
        List<ExampleResponse> exampleResponseList = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(s).getAsJsonArray();
        for (JsonElement jsonElement: jsonArray){
            ExampleResponse exampleResponse = gson.fromJson(jsonElement, ExampleResponse.class);
            exampleResponseList.add(exampleResponse);
        }
        //JsonRecyclerAdapter jsonRecyclerActivity = new JsonRecyclerAdapter(exampleResponseList, JsonActivity.this);

        Log.d(TAG, "onPostExecute: " + exampleResponseList);
        jsonResponseCallback.getResponse(exampleResponseList);
        // jsonItem.setText(s);
    }
    public void jsonCallback(JsonResponseCallback jsonResponseCallback){
        this.jsonResponseCallback = jsonResponseCallback;
    }

}
