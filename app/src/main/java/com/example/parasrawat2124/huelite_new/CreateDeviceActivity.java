package com.example.parasrawat2124.huelite_new;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class CreateDeviceActivity extends AppCompatActivity {
    public static final String TAG="CREARE DEVICE ACTIVITY";
    TextInputEditText textInputEditText;
    Spinner dropdown;
    Button connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_device);
        textInputEditText=findViewById(R.id.DeviceName);
        dropdown=findViewById(R.id.dropdown);
        connect=findViewById(R.id.Connect);

        final AppDatabase appDatabase= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To Be Saving data here
                Log.d(TAG, "onClick: We will Save data here-----" + dropdown.getSelectedItem().toString());
                Log.d(TAG, "onClick: We will save device name here" + textInputEditText.getText().toString());//Point
                appDatabase.userDao().insertAll(new DeviceClass(textInputEditText.getText().toString(),"off",10));
                startActivity(new Intent(CreateDeviceActivity.this,MainActivity.class));

            }
        });

        Button clear=findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appDatabase.userDao().nukeTable();
                startActivity(new Intent(CreateDeviceActivity.this,MainActivity.class));
            }
        });



    }



}
