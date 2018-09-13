package com.example.parasrawat2124.huelite_new;

import android.app.AlertDialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
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
import android.content.DialogInterface;
import android.widget.TextView;

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
    ImageView uparrow;
    List<DeviceClass>devicelist=new ArrayList<>();
   String[] devicenames;
    boolean[] checkeditems;
    ArrayList<Integer> selecteditem=new ArrayList<>();
    ArrayList<String> sizemeasure=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.colorfragment, container, false);
        imageView = view.findViewById(R.id.imageplus);
        multiColorPickerView = view.findViewById(R.id.multiColorPickerView);
        demo = view.findViewById(R.id.imagedemo);
        uparrow = view.findViewById(R.id.updialog);
        imageView.setVisibility(View.GONE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                images.add("Plus One");
                if (!colorchosen.equals("")) {
                    colorstring.add(colorchosen);
                    Log.d(TAG, "Colorstring: " + colorstring);
                }

                recyclerView.setAdapter(adapter);
                Log.d(TAG, "Background" + demo.getBackground());
            }
        });


        multiColorPickerView.addSelector(getResources().getDrawable(R.drawable.markerbig), new ColorListener() {

            @Override
            public void onColorSelected(ColorEnvelope colorEnvelope) {

                int color = colorEnvelope.getColor();
                int[] rgb = colorEnvelope.getRgb();
                String html = colorEnvelope.getHtmlCode();
                colorchosen = "#" + html;
                demo.setBackgroundColor(Color.parseColor(colorchosen));
                Log.d(TAG, "COLOR DRAWABLE: " + colorchosen);
            }

        });

        //to add a customised list of users to be displayed in user list customized checkable dropdown

        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ColorAdapter(getContext(), images, colorstring);
        recyclerView.setAdapter(adapter);


        AppDatabase appDatabase = Room.databaseBuilder(getContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();


        devicelist = appDatabase.userDao().getalldevices();
        devicenames = new String[devicelist.size()];

        for (int i = 0; i < devicelist.size(); i++) {
            devicenames[i] = devicelist.get(i).getDevicename();
        }

        checkeditems = new boolean[devicenames.length];


        uparrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(getActivity());

                mbuilder.setTitle("Devices Available");
                mbuilder.setMultiChoiceItems(devicenames, checkeditems, new DialogInterface.OnMultiChoiceClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int pos, boolean ischecked) {
                        if(ischecked){
                            if(!selecteditem.contains(pos)){
                                selecteditem.add(pos);

                            }
                            else {
                                selecteditem.remove(pos);
                            }
                        }


                    }
                });
                mbuilder.setCancelable(false);
                mbuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        String item="";
                        for(int i=0;i<selecteditem.size();i++){
                            item=item+devicenames[selecteditem.get(i)];
                            sizemeasure.add(item);

                        }
                        if(sizemeasure.size()>0){
                            imageView.setVisibility(View.VISIBLE);
                        }
                        else if(sizemeasure.size()==0){
                            imageView.setVisibility(View.GONE);
                        }
                    }
                });
                mbuilder.setNegativeButton("Dimiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mbuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                         for(int i=0;i<checkeditems.length;i++){
                             checkeditems[i]=false;
                             selecteditem.clear();

                         }
                    }
                });
                AlertDialog dialog=mbuilder.create();
                dialog.show();
            }
        });



        return view;


}
public void checkview(){
    Log.d(TAG, "FUNCTION IS CALLED ");
    if(sizemeasure.size()>0){
        imageView.setVisibility(View.VISIBLE);
    }
}
}

