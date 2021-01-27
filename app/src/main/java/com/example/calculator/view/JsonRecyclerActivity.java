package com.example.calculator.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;
import com.example.calculator.adapter.JsonRecyclerAdapter;
import com.example.calculator.adapter.RecyclerViewAdapter;
import com.example.calculator.model.ExampleArrayResponse;
import com.example.calculator.model.ExampleResponse;
import com.example.calculator.model.JsonResponse;
import com.example.calculator.model.UniversityModel;

import java.util.ArrayList;
import java.util.List;

public class JsonRecyclerActivity extends AppCompatActivity {
    private JsonRecyclerAdapter jsonAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recylerView);
        List<ExampleResponse> responses = new ArrayList<>();


        jsonAdapter = new JsonRecyclerAdapter(responses, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(jsonAdapter);


    }
}