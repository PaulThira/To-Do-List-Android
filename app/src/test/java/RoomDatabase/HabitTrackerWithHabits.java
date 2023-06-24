package RoomDatabase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class HabitTrackerWithHabits {
    @Embedded
    public HabitTracker habitTracker;

    @Relation(parentColumn = "id", entityColumn = "idHabitTracker")
    public List<Habit> habits;
}
