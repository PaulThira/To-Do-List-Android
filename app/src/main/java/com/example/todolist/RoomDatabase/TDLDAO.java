package com.example.todolist.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TDLDAO
{
    @Insert
    public void insert(TDL tdl);
    @Delete
    public void delete(TDL tdl);
    @Update
    public void update(TDL tdl);
    @Query("Select* from tdl")
    public List<TDL> getTDLs();
}
