package com.example.parasrawat2124.huelite_new;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    ArrayList<DeviceClass> user;
    int status;

    public DeviceAdapter(ArrayList<DeviceClass> user) {
        this.user = user;
    }


    @NonNull
    @Override
    public DeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);//acting as finding the layout
    }

    @Override
    public void onBindViewHolder(@NonNull final DeviceAdapter.ViewHolder viewHolder, int i) {
        viewHolder.devicename.setText(user.get(i).getDevicename());
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
                    viewHolder.switchstatus.setText("On");
                }
                else {
                    viewHolder.switchstatus.setText("Off");
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            devicename=itemView.findViewById(R.id.devicename);
            seekBar=itemView.findViewById(R.id.seekbar);
            aSwitch=itemView.findViewById(R.id.switch1);
            percent=itemView.findViewById(R.id.percent);
            switchstatus=itemView.findViewById(R.id.switchstatus);
        }
    }
}
