package com.example.parasrawat2124.huelite_new;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
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

import com.skydoves.multicolorpicker.ColorEnvelope;
import com.skydoves.multicolorpicker.MultiColorPickerView;
import com.skydoves.multicolorpicker.listeners.ColorListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ColorsTab extends Fragment {

    public static final String TAG="DEVICE FRAGMENT";
    MultiColorPickerView multiColorPickerView;

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;
    ImageView imageView;
    List<String> images=new ArrayList<>();
    List<String> colorstring=new ArrayList<>();
    ImageView demo;
    String colorchosen="";
    ColorDrawable colorDrawable;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.colorfragment,container,false);
        imageView=view.findViewById(R.id.imageplus);
        multiColorPickerView=view.findViewById(R.id.multiColorPickerView);
        demo=view.findViewById(R.id.imagedemo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                images.add("Plus One");
                if(!colorchosen.equals("")){
                    colorstring.add(colorchosen);
                    Log.d(TAG, "Colorstring: "+colorstring);
                }

                recyclerView.setAdapter(adapter);
                Log.d(TAG, "Background"+demo.getBackground());
            }
        });


        multiColorPickerView.addSelector(getResources().getDrawable(R.drawable.markerbig), new ColorListener() {

            @Override
            public void onColorSelected(ColorEnvelope colorEnvelope) {

                int color=colorEnvelope.getColor();
                int []rgb=colorEnvelope.getRgb();
                String html=colorEnvelope.getHtmlCode();
                colorchosen="#"+html;
                demo.setBackgroundColor(Color.parseColor(colorchosen));
                Log.d(TAG, "COLOR DRAWABLE: "+colorchosen);
            }

        });



        recyclerView=view.findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ColorAdapter(getContext(),images,colorstring);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
