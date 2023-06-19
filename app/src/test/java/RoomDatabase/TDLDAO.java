package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface TDLDAO
{
    @Insert
    public void insert(TDL tdl);
    @Delete
    public void delete(TDL tdl);
    @Update
    public void update(TDL tdl);
    @Query("Select* from tdls")
    public List<User> getTDLs();
}
