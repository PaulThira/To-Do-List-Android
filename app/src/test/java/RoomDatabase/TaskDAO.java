package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface TaskDAO {
    @Insert
    public void insert(Habit habit);
    @Update
    public void update(Habit habit);
    @Delete
    public void delete(Habit habit);
    @Query("Select * from habits")
    public List<Habit> getAllHabits();
}
