package com.example.courseproject1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract TaskDao taskDao();
}
