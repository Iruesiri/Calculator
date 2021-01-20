package com.example.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerViewAdapter universityAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ArrayList<String> universityList = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);


        universityList.add("covenant university");
        universityList.add("babcock univeristy");
        universityList.add("university of benin");
        universityList.add("university of lagos");
        universityList.add("university of ibadan");
        universityList.add("Bowen University");
        universityList.add("Caleb University");
        universityList.add("University Port-harcourt");
        universityList.add("Delta State University");
        universityList.add("Onobisi onobanjo university");
        universityList.add("Obafemi Awolowo university");
        universityList.add("Madonna university");
        universityList.add("Landmark university");
        universityList.add("university of ife");
        universityList.add("university of jos");
        universityList.add("Kano state university");
        universityList.add("Ahmadu bello university");
        universityList.add("Tai solarin university");
        universityList.add("Lagos state university");
        universityList.add("Enugu state university");
        universityList.add("Rivers state university");
        universityList.add("Futo");
        universityList.add("Futa");
        universityList.add("Futminna");

        universityAdapter = new RecyclerViewAdapter(universityList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(universityAdapter);



    }
}