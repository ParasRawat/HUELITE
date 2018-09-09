package com.example.parasrawat2124.huelite_new;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


//Means this thing will be stored in the database as a table
public class DeviceClass {


    public int getDeviceId() {
        return DeviceId;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getDevicename() {

        return devicename;
    }

    public int getStatus() {
        return status;
    }

    public int getPercentage() {
        return percentage;
    }

    public DeviceClass(String devicename, int status, int percentage) {

        this.devicename = devicename;
        this.status = status;
        this.percentage = percentage;
    }

    private int DeviceId;
    private String devicename;
    private int status;
    private int percentage;

}
