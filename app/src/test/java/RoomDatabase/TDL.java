package RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "TDLS")
public class TDL {

    @PrimaryKey
    public int id;
    @ColumnInfo(name="name")
    public String name;
    @ColumnInfo(name="tasks")
    public List<Task> taskList;
    public TDL(){
        id=1;
        name="things";
        taskList=new ArrayList<Task>();
    }
}
