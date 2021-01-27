package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.adapter.JsonRecyclerAdapter;
import com.example.calculator.callbacks.JsonResponseCallback;
import com.example.calculator.model.ExampleResponse;
import com.example.calculator.model.JsonResponse;

import java.util.List;

public class JsonActivity extends AppCompatActivity {

    //private TextView jsonItem, nameItem, countryItem, houseItem;
    private Button btnHit;
    private RecyclerView recyclerView;
    JsonRecyclerAdapter jsonAdapter;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonpractice);

        recyclerView = findViewById(R.id.recycle);
        btnHit = (Button) findViewById(R.id.jsonBtn);

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.jsonCallback(new JsonResponseCallback() {
            @Override
            public void getResponse(List<ExampleResponse> responseList) {
                jsonAdapter = new JsonRecyclerAdapter(responseList, JsonActivity.this);
                LinearLayoutManager layoutManager = new LinearLayoutManager(JsonActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(jsonAdapter);
            }
        });

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                jsonResponse.execute("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json");
            }
        });
    }
}
