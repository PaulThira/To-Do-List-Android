package com.example.todolist.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TaskDAO {
    @Insert
    public void insert(Task task);
    @Update
    public void update(Task task);
    @Delete
    public void delete(Task task);
    @Query("Select * from tasks")
    public List<Task> getAllTasks();
    @Query("Select name from tasks")
    public List<String> getAllTaskNames();
    @Query("Select dueDate from tasks")
    public List<String> getAllTaskDueDates();
    @Query("Select Status from tasks")
    public List<Boolean> getAllTaskStatuses();
}
