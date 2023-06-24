package RoomDatabase;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
@Dao
public interface HabitTrackerWithHabitsDAO {
    @Transaction
    @Query("SELECT * FROM `habit tracker`")
    List<HabitTrackerWithHabits> getHabitWithHabitTracker();
}
