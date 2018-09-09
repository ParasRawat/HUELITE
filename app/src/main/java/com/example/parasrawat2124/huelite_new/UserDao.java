package com.example.parasrawat2124.huelite_new;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface UserDao {
    @Query("SELECT * FROM DeviceClass")

    List<DeviceClass> getalldevices();

    @Insert
    void insertAll(DeviceClass... deviceClass);

    @Query("DELETE FROM DeviceClass")
    public void nukeTable();

    @Query("UPDATE DeviceClass SET status= :status WHERE device_name=:name")
    int updateitem(String name,String status);
}
