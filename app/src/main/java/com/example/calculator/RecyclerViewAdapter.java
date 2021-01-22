package com.example.calculator;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.model.UniversityModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<UniversityModel> universities;
    Context context;
    public RecyclerViewAdapter(ArrayList<UniversityModel> universities, Context context) {
        this.universities = universities;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.university_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.universityName.setText(universities.get(position).getUniversityName());
        holder.universityState.setText(universities.get(position).getUniversityState());
        holder.universityType.setText(universities.get(position).universityType);
        //holder.universityName.setText(universities.get(position));
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView universityName, universityState, universityType;
        //ImageView universityImage; View cardView; Rating universityRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            universityName = itemView.findViewById(R.id.universityName);
            universityState = itemView.findViewById(R.id.universityState);
            universityType = itemView.findViewById(R.id.universityType);
            //universityImage = itemView.findViewById(R.id.image);
            //universityRating = itemView.findViewById(R.id.ratings);
            //View cardView = itemView.findViewById(R.id.empty);
        }
    }
}
