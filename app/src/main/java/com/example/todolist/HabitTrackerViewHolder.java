package com.example.todolist;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class HabitTrackerViewHolder extends RecyclerView.ViewHolder {
    public Button habitTracker;

    public HabitTrackerViewHolder(@NonNull View itemView) {
        super(itemView);
        habitTracker=itemView.findViewById(R.id.Tdl);

        habitTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_HabitTrackers_to_Habits);
            }
        });
    }
}
