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

public class JsonRecyclerAdapter extends RecyclerView.Adapter<JsonRecyclerAdapter.ViewHolder> {
    List<ExampleResponse> items;
    Context context;

    public JsonRecyclerAdapter(List<ExampleResponse> items, Context context) {
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public JsonRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jsonitem, parent, false);
        return new JsonRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonRecyclerAdapter.ViewHolder holder, int position) {
        holder.jsonItem.setText(items.get(position).getID());
        holder.nameItem.setText(items.get(position).getName());
        holder.countryItem.setText(items.get(position).getCountry());
        holder.houseItem.setText(items.get(position).getHouse());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView jsonItem, nameItem, houseItem, countryItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jsonItem = itemView.findViewById(R.id.jsonItem);
            nameItem = itemView.findViewById(R.id.nameValue);
            houseItem = itemView.findViewById(R.id.houseValue);
            countryItem = itemView.findViewById(R.id.countryValue);
        }
    }
}
