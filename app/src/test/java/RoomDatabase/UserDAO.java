package RoomDatabase;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface UserDAO {
    @Insert
    public void insert(User user);
    @Delete
    public void delete(User user);
    @Update
    public void update(User user);
    @Query("Select* from users")
    public List<User> getUsers();
    @Query("Select * from users where id =:ids")
    public List<User> getUsersById(int ids);

}
