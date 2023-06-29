package com.example.todolist;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TDLViewHolder extends RecyclerView.ViewHolder {
    Button Tdl;
    public TDLViewHolder(@NonNull View itemView) {
        super(itemView);
        Tdl=itemView.findViewById(R.id.habitTrackerList);
    }
}
