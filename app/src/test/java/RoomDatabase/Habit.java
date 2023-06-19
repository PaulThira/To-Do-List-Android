package RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "habits")
public class Habit {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "streak")
    public int streak;
    public Habit(){
        id=0;
        name="drinking";
        streak=0;
    }
}
