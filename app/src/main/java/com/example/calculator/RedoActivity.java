package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.calculator.adapter.RedoRecycleAdapter;
import com.example.calculator.callbacks.JsonResponseCallback;
import com.example.calculator.model.ExampleResponse;
import com.example.calculator.model.JsonResponse;

import java.util.List;

public class RedoActivity extends AppCompatActivity {

    private RedoRecycleAdapter redoAdapter;
    private RecyclerView recyclerView;
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redorecycler);

        recyclerView = findViewById(R.id.recyclerView);
        btnClick = (Button) findViewById(R.id.btnClick);

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.jsonCallback(new JsonResponseCallback() {
            @Override
            public void getResponse(List<ExampleResponse> responseList) {
                redoAdapter = new RedoRecycleAdapter(responseList, RedoActivity.this);
                LinearLayoutManager layoutManager = new LinearLayoutManager(RedoActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(redoAdapter);
            }
        });
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                jsonResponse.execute("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json");
            }
        });
    }
}