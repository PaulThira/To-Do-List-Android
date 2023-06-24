package RoomDatabase;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface TDLWithTasksDAO {
    @Transaction
    @Query("SELECT * FROM TDL")
    List<TDLWithTasks> getTDLWithTasks();
}
