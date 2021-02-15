package com.example.calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;
import com.example.calculator.model.ExampleResponse;

import java.util.ArrayList;
import java.util.List;

public class RedoRecycleAdapter extends RecyclerView.Adapter<RedoRecycleAdapter.viewHolder> {
    List<ExampleResponse> responses = new ArrayList<>();
    Context context;

    public RedoRecycleAdapter(List<ExampleResponse> responses, Context context){
        this.responses = responses;
        this.context = context;
    }
    @NonNull
    @Override
    public RedoRecycleAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.redo_item, parent, false);
        return new RedoRecycleAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RedoRecycleAdapter.viewHolder holder, int position) {
        holder.employeeId.setText(responses.get(position).getID().toString());
        holder.name.setText(responses.get(position).getName());
        holder.country.setText(responses.get(position).getCountry());
        holder.house.setText(responses.get(position).getHouse());
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView employeeId, name, house, country;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            employeeId = itemView.findViewById(R.id.employeeId);
            name = itemView.findViewById(R.id.name);
            house = itemView.findViewById(R.id.house);
            country = itemView.findViewById(R.id.country);
        }
    }
}
