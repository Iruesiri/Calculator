package com.example.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author .: Ossai Michael
 * @email ..: mikeossaiofficial@gmail.com, michael.ossai@cwg-plc.com
 * @created : 20/01/2021 11:54
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
   ArrayList<String> universities;
   Context context;
    public RecyclerViewAdapter(ArrayList<String> universities, Context context) {
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
        holder.universityName.setText(universities.get(position));
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView universityName, universityState;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            universityName = itemView.findViewById(R.id.universityName);
            universityState = itemView.findViewById(R.id.universityState);
        }
    }
}
