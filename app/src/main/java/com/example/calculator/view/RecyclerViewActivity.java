package com.example.calculator.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;
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

        ArrayList<UniversityModel> universityList = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);

        universityList.add(new UniversityModel("Covenant", "Ogun State", "Private"));
        universityList.add(new UniversityModel("Babcock", "Ogun State", "Private"));
        universityList.add(new UniversityModel("Bowen", "Osun State", "Private"));
        universityList.add(new UniversityModel("Madonna University", "River State", "Private"));
        universityList.add(new UniversityModel("University of lagos", "Laogs State", "Federal"));
        universityList.add(new UniversityModel("University of Benin", "Edo State", "Federal"));


        universityAdapter = new RecyclerViewAdapter(universityList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(universityAdapter);



    }
}