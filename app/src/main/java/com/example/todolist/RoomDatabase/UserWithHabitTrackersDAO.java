package com.example.todolist.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
@Dao
public interface UserWithHabitTrackersDAO {
    @Transaction
    @Query("SELECT * FROM users")
    List<UserWithHabitTrackers> getDepartmentsWithEmployees();
}
