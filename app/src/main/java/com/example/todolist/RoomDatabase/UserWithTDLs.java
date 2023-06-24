package com.example.todolist.RoomDatabase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithTDLs {
    @Embedded
    public User user;

    @Relation(parentColumn = "id", entityColumn = "idUser")
    public List<TDL> tdlList;
}
