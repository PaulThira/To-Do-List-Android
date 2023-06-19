package RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey
    public int id;
    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name="status")
    public boolean status;
    @ColumnInfo(name="dueDate")
    public Date dueDate;
    public Task(){
        id=1;
        name="item";
        status=true;
        dueDate= new Date();
    }
}
