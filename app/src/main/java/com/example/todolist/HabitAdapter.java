package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitViewHolder> {
    private List<String> items;
    private List<String> dates;
    private List<Boolean> doneItems;
    public HabitAdapter(List<String> Items,List<String> Dates,List<Boolean> DoneItems) {
        this.dates=Dates;
        this.items=Items;
        this.doneItems=DoneItems;
    }
    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.habitlayout, parent, false);
        return new HabitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        String itemTexts = items.get(position);
        String dateTexts=dates.get(position);
        holder.date.setText(dateTexts);
        Boolean doneStatus=doneItems.get(position);
        holder.done.setChecked(doneStatus);
        holder.item.setText(itemTexts);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
