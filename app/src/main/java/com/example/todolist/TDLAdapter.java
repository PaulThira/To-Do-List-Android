package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TDLAdapter extends RecyclerView.Adapter<TDLViewHolder> {
    private List<String> habitTrackers;
    public TDLAdapter(List<String> habitTrackers){
        this.habitTrackers=habitTrackers;
    }
    @NonNull
    @Override
    public TDLViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tdlitemlayout, parent, false);
        return new TDLViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TDLViewHolder holder, int position) {
        String item = habitTrackers.get(position);
        holder.Tdl.setText(item);
    }

    @Override
    public int getItemCount() {
        return habitTrackers.size();
    }
}
