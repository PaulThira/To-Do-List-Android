package RoomDatabase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class TDLWithTasks {
    @Embedded
    public TDL tdl;

    @Relation(parentColumn = "id", entityColumn = "idTDL")
    public List<Task> tasks;
}
