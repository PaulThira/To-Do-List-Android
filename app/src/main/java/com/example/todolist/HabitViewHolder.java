package com.example.todolist;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HabitViewHolder extends RecyclerView.ViewHolder {
    public TextView item;
    public TextView date;
    public CheckBox done;
    public HabitViewHolder(@NonNull View itemView) {
        super(itemView);
        item=itemView.findViewById(R.id.item);
        date=itemView.findViewById(R.id.date);
        done=itemView.findViewById(R.id.done);
    }
}
