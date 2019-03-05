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

    public ArrayList<ModelActivity> getTList(){
        return List;
    }

    public void TList(ArrayList<ModelActivity> TList){
        this.List = TList;


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
        Glide.with(context).load(getTList().get(i).getThumbnail()).into(viewHolder.ivThumbail);
        viewHolder.tvTitle.setText(getTList().get(i).getTitle());
        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DescActivity.class);
                intent.putExtra("img_url", getTList().get(i).getThumbnail());
                intent.putExtra("title",getTList().get(i).getTitle());
                intent.putExtra("detail",getTList().get(i).getDetail());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getTList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbail;
        TextView tvTitle;
        Button btnShow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbail = itemView.findViewById(R.id.team_thumbnail);
            tvTitle = itemView.findViewById(R.id.team_name);
            btnShow = itemView.findViewById(R.id.btn_lihat);

        }
    }}