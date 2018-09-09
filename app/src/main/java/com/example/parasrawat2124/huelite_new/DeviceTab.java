package com.example.parasrawat2124.huelite_new;

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

public class DeviceTab extends Fragment {
    
    public static final String TAG="DEVICE FRAGMENT";
    FloatingActionButton floatingActionButton;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
     ArrayList<String> devices;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.devicefragment,container,false);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        recyclerView=view.findViewById(R.id.recyclerview);
        devices=new ArrayList<>();
        devices.add("Device");
        devices.add("Device 2");
        devices.add("Device 3");
        devices.add("Device 4");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new DeviceAdapter(devices);
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
