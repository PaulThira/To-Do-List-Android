package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface HabitDAO {
    @Insert
    public void insert(Habit habit);
    @Delete
    public void delete(Habit habit);
    @Update
    public void update(Habit habit);
    @Query("Select* from habits")
    public List<User> getHabits();
}
