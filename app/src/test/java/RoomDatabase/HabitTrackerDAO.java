package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface HabitTrackerDAO {
    @Insert
    public void insert(HabitTracker habitTracker);
    @Delete
    public void delete(HabitTracker habitTracker);
    @Update
    public void update(HabitTracker habitTracker);
    @Query("Select* from `habit tracker`")
    public List<User> getHabitTrackers();
}
