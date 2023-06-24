package RoomDatabase;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "habits",
        foreignKeys = @ForeignKey(entity = HabitTracker.class,
        parentColumns = "id",
        childColumns = "idHabitTracker"
        )
)
public class Habit {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "streak")
    public int streak;
    @ColumnInfo(name="IdHabitTracker")
    public int idHabitTracker;
    public Habit(){
        id=1;
        name="drinking";
        streak=0;
        idHabitTracker=1;
    }
}
