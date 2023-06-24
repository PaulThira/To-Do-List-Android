package com.example.todolist.RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit tracker",foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "idUser"
      ))
public class HabitTracker {
    @PrimaryKey
    public int id;
    @ColumnInfo(name=" tracker name")
    public String name;
    @ColumnInfo(name = "idUser")
    public int idUser;
    public HabitTracker(){
        id=1;
        name="tracker";
        idUser=1;

    }
}
