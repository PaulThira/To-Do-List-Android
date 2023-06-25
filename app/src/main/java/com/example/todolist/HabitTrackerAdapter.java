package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitTrackerAdapter extends RecyclerView.Adapter<HabitTrackerViewHolder> {
    private List<String> HabitTrackers;
    public HabitTrackerAdapter(List<String> HabitTrackers){
        this.HabitTrackers=HabitTrackers;
    }
    @NonNull
    @Override
    public HabitTrackerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habittrackerlayout, parent, false);
        return new HabitTrackerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitTrackerViewHolder holder, int position) {
        String item = HabitTrackers.get(position);
        holder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return HabitTrackers.size();
    }
}
