package com.example.todolist.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "habits")

public class Habit {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "streak")
    public int streak;
    @ColumnInfo(name="IdHabitTracker")
    public int IdHabitTracker;
    public Habit(){
        id=1;
        name="drinking";
        streak=0;
        IdHabitTracker=1;
    }
}
