package com.example.zomatoapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoapplication.R;
import com.example.zomatoapplication.databinding.AdapterCuisineLayoutBinding;

import java.util.ArrayList;

public class RestaurantCuisineAdapter extends RecyclerView.Adapter<RestaurantCuisineAdapter.ViewHolder> {

    private ArrayList<String> list;
    private LayoutInflater layoutInflater;

    public RestaurantCuisineAdapter(Context context, ArrayList<String> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterCuisineLayoutBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.adapter_cuisine_layout,  parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.textCategoryName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterCuisineLayoutBinding binding;
        public ViewHolder(@NonNull AdapterCuisineLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
