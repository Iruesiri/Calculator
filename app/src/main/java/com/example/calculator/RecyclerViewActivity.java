package com.example.calculator;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.calculator.adapter.RecyclerViewAdapter;
import com.example.calculator.model.UniversityModel;


import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerViewAdapter universityAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recylerView);
        ArrayList<UniversityModel> universityModels = new ArrayList<>();

        universityModels.add(new UniversityModel("Covenant university", "Ogun state", "Private"));
        universityModels.add(new UniversityModel("Babcock university", "Ogun state", "Private"));
        universityModels.add(new UniversityModel("University of Benin", "Edo state", "Public"));
        universityModels.add(new UniversityModel("Bowen university", "Osun state", "Private"));
        universityModels.add(new UniversityModel("University of Ife", "Ibadon state", "Public"));
        universityModels.add(new UniversityModel("Madonna University", "River State", "Private"));
        universityModels.add(new UniversityModel("University of lagos", "Laogs State", "Federal"));


        universityAdapter = new RecyclerViewAdapter(universityModels, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(universityAdapter);


    }
}