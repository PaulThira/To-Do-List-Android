package RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tasks", foreignKeys = @ForeignKey(entity = TDL.class,
        parentColumns = "id",
        childColumns = "idTDL"
        ))
public class Task {
    @PrimaryKey
    public int id;
    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name="status")
    public boolean status;
    @ColumnInfo(name="dueDate")
    public Date dueDate;
    @ColumnInfo(name="idTDL")
    public int idTDL;
    public Task(){
        id=1;
        name="item";
        status=true;
        dueDate= new Date();
        idTDL=1;
    }
}
