package com.example.parasrawat2124.huelite_new;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.widget.SeekBar;


//Means this thing will be stored in the database as a table//We created a database basically from our getter and the setter class
@Entity
public class DeviceClass {

    @PrimaryKey(autoGenerate = true)
    private int DeviceId;

    @ColumnInfo(name="device_name")
    private String devicename;
    @ColumnInfo(name ="status")
    private String status;
    @ColumnInfo(name = "percentage")
    private int percentage;

    public void setDeviceId(int deviceId) {
        DeviceId = deviceId;
    }

    public int getDeviceId() {
        return DeviceId;
    }

    //    public int getDeviceId() {
//        return DeviceId;
//    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getDevicename() {

        return devicename;
    }

    public String getStatus() {
        return status;
    }

    public int getPercentage() {
        return percentage;
    }

    public DeviceClass(String devicename, String status, int percentage) {

        this.devicename = devicename;
        this.status = status;
        this.percentage = percentage;
    }


}
