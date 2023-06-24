package com.example.todolist.RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "TDL",foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "idUser",
        onDelete = ForeignKey.CASCADE))
public class TDL {

    @PrimaryKey
    public int id;
    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name = "idUser")
    public int idUser;

    public TDL(){
        id=1;
        name="things";
        idUser=1;

    }
}
