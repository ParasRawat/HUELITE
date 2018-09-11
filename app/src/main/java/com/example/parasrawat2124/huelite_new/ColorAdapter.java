package com.example.parasrawat2124.huelite_new;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    public static final String TAG="COLOR ADAPTER";
    List<String> imagesList;
    List<String> list;
    Context mcontext;
    String colorl;
    ColorDrawable colorDrawable;


    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.colorlist_item,viewGroup,false);
        return new ColorAdapter.ViewHolder(view);

    }

    public ColorAdapter() {
    }

    public  ColorAdapter(Context context, List<String> imagesList, List<String> color){
        this.mcontext=context;
        this.imagesList=imagesList;
        this.list=color;
//        this.colorcodes=colorcodes;
//        this.colorlistcodes=colorlistcodes;
//        Log.d(TAG, "ColorAdapter: "+imagesList);
    }



    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.ViewHolder viewHolder, int i) {

        if(list.size()>0) {
            viewHolder.imageView.setBackgroundColor(Color.parseColor(list.get(i)));
        }
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.colorcontent);
        }
    }
}
