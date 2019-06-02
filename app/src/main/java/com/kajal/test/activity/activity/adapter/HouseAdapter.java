package com.kajal.test.activity.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kajal.test.R;
import com.kajal.test.activity.activity.model.ResultHouse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder> {

    private List<ResultHouse> houses;
    private int rowLayout;
    private Context context;


    public static class HouseViewHolder extends RecyclerView.ViewHolder{
        LinearLayout houseLayout;
        TextView houseName;
        TextView data;
        TextView Description;
        TextView address;
        ImageView houseImage;


        public HouseViewHolder(View v){
            super(v);
            houseLayout =  v.findViewById(R.id.house_layout);
            houseName = v.findViewById(R.id.title);
            data  = v.findViewById(R.id.subtitle);
            Description = v.findViewById(R.id.description);
            address = v.findViewById(R.id.rating);
            houseImage = v.findViewById(R.id.rating_image);

        }
    }
    public HouseAdapter(List<ResultHouse> houses,int rowLayout,Context context){
        this.houses = houses;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public HouseAdapter.HouseViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        return new HouseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HouseViewHolder holder, final int position) {
        holder.houseName.setText(houses.get(position).getName());
        holder.Description.setText("Area: "+houses.get(position).getHouse_size());
        holder.address.setText(houses.get(position).getFurnish_type());
        Picasso.with(context).load(houses.get(position).getCover_pic_url()).into(holder.houseImage);
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }

}
