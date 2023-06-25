package com.example.todolist.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UserDAO {
    @Insert
    public void insert(User user);
    @Delete
    public void delete(User user);
    @Update
    public void update(User user);
    @Query("Select* from users")
    public List<User> getUsers();
    @Query("Select * from users where name=:names and email=:emails")
    public List<User> getUsersByNameAndEmail(String names, String emails);
    @Query("Select * from users where name=:names ")
    public List<User> getUserByName(String names);

}
