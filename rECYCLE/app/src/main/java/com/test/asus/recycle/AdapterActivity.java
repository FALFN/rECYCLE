package com.test.asus.recycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {
    private Context context;
    private ArrayList<ModelActivity> List;

    public AdapterActivity(Context context){
        this.context = context;
    }

    public ArrayList<ModelActivity> getFootbalList(){
        return List;
    }

    public void setFootbalList(ArrayList<ModelActivity> footbalList){
        this.List = footbalList;


}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getFootbalList().get(i).getThumbnail()).into(viewHolder.ivThumbail);
        viewHolder.tvTitle.setText(getFootbalList().get(i).getTitle());
        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DescActivity.class);


                intent.putExtra("img_url", getFootbalList().get(i).getThumbnail());
                intent.putExtra("title",getFootbalList().get(i).getTitle());
                intent.putExtra("detail",getFootbalList().get(i).getDetail());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getFootbalList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbail;
        TextView tvTitle;
        Button btnShow,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbail = itemView.findViewById(R.id.team_thumbnail);
            tvTitle = itemView.findViewById(R.id.team_name);
            btnShow = itemView.findViewById(R.id.btn_lihat);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }}