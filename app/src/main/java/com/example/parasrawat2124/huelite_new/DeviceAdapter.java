package com.example.parasrawat2124.huelite_new;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    List<DeviceClass> user;
    int status;
    Context context;



    public DeviceAdapter(List<DeviceClass> user,Context context) {
        this.user = user;
        this.context=context;
    }


    @NonNull
    @Override
    public DeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);//acting as finding the layout
    }

    @Override
    public void onBindViewHolder(@NonNull final DeviceAdapter.ViewHolder viewHolder, int i) {

        final AppDatabase appDatabase= Room.databaseBuilder(context,AppDatabase.class,"production")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        final String devicename=user.get(i).getDevicename();

        viewHolder.devicename.setText(user.get(i).getDevicename());

        String status;
        status=user.get(i).getStatus();
        Log.d("ADAPTER TAGE", "onBindViewHolder: ");

        if(status.equals("On")){
            viewHolder.bulb.setImageResource(R.drawable.bulbglow);
            viewHolder.aSwitch.setChecked(true);
        }

        else {
            viewHolder.bulb.setImageResource(R.drawable.bulboff);


        }
        viewHolder.switchstatus.setText(user.get(i).getStatus());
        viewHolder.seekBar.setProgress(user.get(i).getPercentage());
        viewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                viewHolder.percent.setText(i+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        viewHolder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    int i=1;
                    viewHolder.switchstatus.setText("On");
                    viewHolder.bulb.setImageResource(R.drawable.bulbglow);
                    appDatabase.userDao().updateitem(devicename,"On");
                }
                else {
                    int i=0;
                    appDatabase.userDao().updateitem(devicename,"OFF");
                    viewHolder.switchstatus.setText("Off");
                    viewHolder.bulb.setImageResource(R.drawable.bulboff);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {//Acting as find the view in the layout
        public TextView devicename;
        public SeekBar seekBar;
        public Switch aSwitch;
        public TextView percent;
        public TextView switchstatus;
        public ImageView bulb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            devicename=itemView.findViewById(R.id.devicename);
            seekBar=itemView.findViewById(R.id.seekbar);
            aSwitch=itemView.findViewById(R.id.switch1);
            percent=itemView.findViewById(R.id.percent);
            switchstatus=itemView.findViewById(R.id.switchstatus);
            bulb=itemView.findViewById(R.id.bulb);
        }
    }
}
