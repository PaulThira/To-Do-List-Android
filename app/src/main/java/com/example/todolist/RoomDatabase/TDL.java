package com.example.todolist.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TDL")
public class TDL {

    @PrimaryKey
    public int id;
    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name = "idUser")
    public int idUser;
    @ColumnInfo(name = "inUse")
    public boolean inUse;

    public TDL(){
        id=1;
        name="things";
        idUser=1;
        inUse=false;

    }
}
