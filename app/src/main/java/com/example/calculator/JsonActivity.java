package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.model.JsonResponse;

public class JsonActivity extends AppCompatActivity {

    private TextView jsonItem, nameItem, countryItem, houseItem;
    private Button btnHit;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonpractice);

        btnHit = (Button) findViewById(R.id.jsonBtn);
        jsonItem = (TextView) findViewById(R.id.jsonItem);
        nameItem = (TextView) findViewById(R.id.nameValue);
        houseItem = (TextView) findViewById(R.id.houseValue);
        countryItem = (TextView) findViewById(R.id.countryValue);

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                new JsonResponse().execute("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json");
            }
        });
    }
}
