package com.example.parasrawat2124.huelite_new;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.util.concurrent.RecursiveAction;

public class ColorsTab extends Fragment {

    public static final String TAG="DEVICE FRAGMENT";

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;
    ImageView imageView;
    List<String> images=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.colorfragment,container,false);
        imageView=view.findViewById(R.id.imageplus);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                images.add("Plus One");
                recyclerView.setAdapter(adapter);
                Log.d(TAG, "ImagesList: "+images);
            }
        });
        recyclerView=view.findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ColorAdapter(getContext(),images);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
