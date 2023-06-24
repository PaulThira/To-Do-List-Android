package RoomDatabase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithHabitTrackers {
    @Embedded
    public User users;

    @Relation(parentColumn = "id", entityColumn = "idUser")
    public List<HabitTracker> habitTrackerList;
}
