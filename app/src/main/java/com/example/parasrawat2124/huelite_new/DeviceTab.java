package com.example.parasrawat2124.huelite_new;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class DeviceTab extends Fragment {
    
    public static final String TAG="DEVICE FRAGMENT";
    FloatingActionButton floatingActionButton;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
//     ArrayList<DeviceClass> devices;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.devicefragment,container,false);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        recyclerView=view.findViewById(R.id.recyclerview);
//        devices=new ArrayList<>();
//        for(int i=0;i<11;i++) {
//            DeviceClass deviceClass = new DeviceClass("Device"+i, 1, 20);
//            devices.add(deviceClass);
//        }
        AppDatabase appDatabase= Room.databaseBuilder(getContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<DeviceClass> deviceClassArrayList = appDatabase.userDao().getalldevices();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new DeviceAdapter(deviceClassArrayList,getContext());
        recyclerView.setAdapter(adapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Pressed");
                startActivity(new Intent(getActivity(),CreateDeviceActivity.class));
            }
        });
        return view;
        
}
}
