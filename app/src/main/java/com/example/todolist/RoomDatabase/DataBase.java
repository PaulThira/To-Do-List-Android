package com.example.todolist.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class,Habit.class,Task.class,TDL.class,HabitTracker.class},version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract TaskDAO taskDAO();
    public abstract HabitDAO habitDAO();
    public abstract HabitTrackerDAO habitTrackerDAO();
    public abstract TDLDAO tdldao();


}
