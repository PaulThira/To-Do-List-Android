package com.example.todolist.RoomDatabase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "loggedIn")
    public boolean loggedIn;
    public void setName(String names){
        this.name=names;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    public User(){
        id=1;
        name="person";
        email="thing@gmail.com";
        password="password";
        loggedIn=true;

    }



}
