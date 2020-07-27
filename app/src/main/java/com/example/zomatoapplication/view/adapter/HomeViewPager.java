package com.example.zomatoapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.zomatoapplication.R;
import com.example.zomatoapplication.databinding.AdapterViewpagerLayoutBinding;
import com.example.zomatoapplication.pojo.ViewPagerData;

import java.util.ArrayList;

public class HomeViewPager extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<ViewPagerData> list;

    public HomeViewPager (Context context, ArrayList<ViewPagerData> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;

    }

    @Override
    public int getCount() {
        return (list.size());
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       AdapterViewpagerLayoutBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.adapter_viewpager_layout, container, false);
        binding.setAdsData(list.get(position));
        Glide.with(context).load(list.get(position).getImage()).into(binding.imageViewPager);
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
