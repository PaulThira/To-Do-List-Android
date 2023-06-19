package RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "habit tracker")
public class HabitTracker {
    @PrimaryKey
    public int id;
    @ColumnInfo(name=" tracker name")
    public String name;
    @ColumnInfo(name = "Habits")
    public List<Habit>habitList;
    public HabitTracker(){
        id=1;
        name="tracker";
        habitList=new ArrayList<Habit>();
    }
}
