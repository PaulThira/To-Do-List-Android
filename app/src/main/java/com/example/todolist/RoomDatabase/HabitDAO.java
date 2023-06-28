package com.example.todolist.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface HabitDAO {
    @Insert
    public void insert(Habit habit);
    @Delete
    public void delete(Habit habit);
    @Update
    public void update(Habit habit);
    @Query("Select* from habits")
    public List<Habit> getHabits();
    @Query("Select name from habits")
    public List<String> getHabitNames();

}
