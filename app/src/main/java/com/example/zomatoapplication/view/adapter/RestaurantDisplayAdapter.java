package com.example.zomatoapplication.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zomatoapplication.R;
import com.example.zomatoapplication.databinding.AdapterRestaurantLayoutBinding;
import com.example.zomatoapplication.pojo.DisplayList;

import java.util.ArrayList;

public class RestaurantDisplayAdapter extends
        RecyclerView.Adapter<RestaurantDisplayAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<DisplayList> displayListArrayList;

    public RestaurantDisplayAdapter(Context context, ArrayList<DisplayList> displayListArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.displayListArrayList = displayListArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterRestaurantLayoutBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.adapter_restaurant_layout, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(displayListArrayList.get(position).getIsDeliveringNow()==1){
            holder.binding.textAvailable.setText("Available..");
            holder.binding.textAvailable.setBackgroundColor(context.getResources()
                    .getColor(R.color.lightGreen));
            holder.binding.cardMain.setCardBackgroundColor(context.getResources()
                    .getColor(R.color.colorWhite));
        }else {
            holder.binding.textAvailable.setText("Not Available Now");
            holder.binding.textAvailable.setBackgroundColor(context.getResources()
                    .getColor(R.color.colorAccent));
            holder.binding.cardMain.setCardBackgroundColor(context.getResources()
                    .getColor(R.color.greyCardBackground));
        }
        Glide.with(context).load(displayListArrayList.get(position).getRestaurantThumb())
                .error(context.getResources().getDrawable(R.drawable.ic_app_thumbnail))
                .into(holder.binding.imageHotel);
        holder.binding.setRestaurantData(displayListArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return displayListArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterRestaurantLayoutBinding binding;
        public ViewHolder(@NonNull AdapterRestaurantLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
