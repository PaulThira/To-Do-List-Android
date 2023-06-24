package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface TaskDAO {
    @Insert
    public void insert(Task task);
    @Update
    public void update(Task task);
    @Delete
    public void delete(Task task);
    @Query("Select * from tasks")
    public List<Task> getAllTasks();
}
