package com.example.parasrawat2124.huelite_new;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    ArrayList<String> user;

    public DeviceAdapter(ArrayList<String> user) {
        this.user = user;
    }


    @NonNull
    @Override
    public DeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);//acting as finding the layout
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceAdapter.ViewHolder viewHolder, int i) {
        viewHolder.devicename.setText(user.get(i));
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {//Acting as find the view in the layout
        public TextView devicename;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            devicename=itemView.findViewById(R.id.devicename);
        }
    }
}
