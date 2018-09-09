package com.example.parasrawat2124.huelite_new;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DeviceClass.class},version = 2)

public abstract class AppDatabase extends RoomDatabase {



    public abstract UserDao userDao();
}
