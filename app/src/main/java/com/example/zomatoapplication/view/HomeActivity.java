package com.example.zomatoapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zomatoapplication.R;
import com.example.zomatoapplication.databinding.ActivityHomeBinding;
import com.example.zomatoapplication.pojo.DisplayList;
import com.example.zomatoapplication.pojo.NearbyRestaurant;
import com.example.zomatoapplication.pojo.ViewPagerData;
import com.example.zomatoapplication.utility.Utility;
import com.example.zomatoapplication.view.adapter.HomeViewPager;
import com.example.zomatoapplication.view.adapter.RestaurantCuisineAdapter;
import com.example.zomatoapplication.view.adapter.RestaurantDisplayAdapter;
import com.example.zomatoapplication.viewmodel.HomeViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.zomatoapplication.utility.Utility.UPDATE_INTERVAL;
import static com.example.zomatoapplication.utility.Utility.isInternetAvailable;
import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class HomeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        LocationListener {

    private ActivityHomeBinding binding;
    private HomeViewModel homeViewModel;
    private ArrayList<String> listCategory;
    private ArrayList<ViewPagerData> addDataList;
    private ImageView[] imageDotsArray;
    private ImageChangeHandler imageChangeHandler = new ImageChangeHandler();
    private static int currentPage = -1;
    private int imagesLength;
    private double lat, lon;
    private Animation animationRight, animationDots, animationBottom;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        binding.swipeRefresh.setOnRefreshListener(this::onResume);
        animationRight = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);
        animationDots = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        animationBottom = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top);
    }


    @Override
    protected void onResume() {
        if (isInternetAvailable(this)) {
            binding.swipeRefresh.setRefreshing(true);
            getLastLocation();
        } else {
            binding.swipeRefresh.setRefreshing(false);
            binding.scrollView.setVisibility(GONE);
            binding.textError.setText(R.string.internetError);
            binding.textError.setVisibility(VISIBLE);
        }
        super.onResume();
    }

    protected void startLocationUpdates() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(Utility.FASTEST_INTERVAL);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest,
                new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        onLocationChanged(locationResult.getLastLocation());
                    }
                }, Looper.myLooper());
    }

    public void getLastLocation() {
        FusedLocationProviderClient locationClient = getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            startLocationUpdates();
            return;
        }
        locationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        onLocationChanged(location);
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(HomeActivity.this,
                        "Error trying to get last GPS location", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
        getListData();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    private void getListData() {
        homeViewModel.getZomatoApi(lat, lon).observe(this, zomatoAPI -> {
            binding.swipeRefresh.setRefreshing(false);
            if(zomatoAPI!= null){
                String title = zomatoAPI.getLocation().getTitle()+", "
                        + zomatoAPI.getLocation().getCityName();
                binding.textLocationName.setText(title);
                listCategory = new ArrayList<>(zomatoAPI.getPopularity().getTopCuisines());
                List<NearbyRestaurant> list = zomatoAPI.getNearbyRestaurants();
                ArrayList<DisplayList> displayAdapterList = new ArrayList<>();
                ArrayList<ViewPagerData> viewPagerDataList = new ArrayList<>();
                for(NearbyRestaurant item : list){
                    String featureImage = item.getRestaurant().getFeaturedImage();
                    String name = item.getRestaurant().getName();
                    String address = item.getRestaurant().getLocation().getAddress();
                    String locality = item.getRestaurant().getLocation().getLocalityVerbose();
                    String cuisine = item.getRestaurant().getCuisines();
                    String price = item.getRestaurant().getCurrency()+": " +
                            item.getRestaurant().getAverageCostForTwo()+"/2 Persons";
                    String thumb = item.getRestaurant().getThumb();
                    String userRating = item.getRestaurant().getUserRating().getAggregateRating();
                    String textRating = item.getRestaurant().getUserRating().getRatingText();
                    String colourRating = item.getRestaurant().getUserRating().getRatingColor();
                    String votes = "("+item.getRestaurant().getUserRating().getVotes()+ "Views)";
                    int isDeliveryNow = Integer.parseInt(String.valueOf
                            (item.getRestaurant().getIsDeliveringNow()));
                    int hasOnlineDelivery = Integer.parseInt(String.valueOf(item
                            .getRestaurant().getHasOnlineDelivery()));
                    ViewPagerData viewPagerData = new ViewPagerData(featureImage, name);
                    viewPagerDataList.add(viewPagerData);
                    DisplayList displayListData = new DisplayList(name, address, locality,
                            cuisine, price, thumb, userRating, textRating, votes, colourRating,
                            hasOnlineDelivery, isDeliveryNow);
                    displayAdapterList.add(displayListData);
                }
                addDataList =new ArrayList<>();
                addDataList.clear();
                addDataList.addAll(viewPagerDataList);
                binding.scrollView.setVisibility(VISIBLE);
                binding.textError.setVisibility(VISIBLE);
                setViewPagerAdapter();
                setCategoryAdapter();
                setAdapter(displayAdapterList);
                binding.layoutDots.removeAllViews();
                setUiPageViewController();
            }else {
                binding.scrollView.setVisibility(GONE);
                binding.textError.setText(R.string.serverError);
                binding.textError.setVisibility(VISIBLE);
            }

        });
    }

    private void setViewPagerAdapter() {
        HomeViewPager homeImageSwipeAdapter = new HomeViewPager(this, addDataList);
        binding.viewPager.setAdapter(homeImageSwipeAdapter);
        binding.viewPager.setCurrentItem(0);
        binding.viewPager.setPadding(10, 0, 8, 0);
        binding.viewPager.setOnPageChangeListener(this);
        binding.layoutDots.setAnimation(animationDots);
    }

    private void setCategoryAdapter(){
        binding.recyclerViewCategory.setHasFixedSize(true);
        binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewCategory.setAdapter(new RestaurantCuisineAdapter(this, listCategory));
        binding.recyclerViewCategory.setAnimation(animationRight);
    }

    private void setAdapter(ArrayList<DisplayList> lists) {
        binding.recyclerViewRestaurant.setHasFixedSize(true);
        binding.recyclerViewRestaurant.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        binding.recyclerViewRestaurant.setAdapter(new RestaurantDisplayAdapter(this, lists));
        binding.recyclerViewRestaurant.setAnimation(animationBottom);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < addDataList.size(); i++) {
            imageDotsArray[i].setImageDrawable(getResources()
                    .getDrawable(R.drawable.ad_item_not_selected));
        }
        imageDotsArray[position].setImageDrawable(getResources()
                .getDrawable(R.drawable.ad_item_selected));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    private void startAutoImageChange(){
        imageChangeHandler.sleep();
        if(imagesLength>0){
            if (currentPage== imagesLength){
                currentPage=0;
            } else {
                currentPage++;
            }
            binding.viewPager.setCurrentItem(currentPage);
        } else {imageChangeHandler.removeCallbacksAndMessages(null);}
    }

    @SuppressLint("HandlerLeak")
    private class ImageChangeHandler extends Handler {

        @Override
        public void handleMessage(@NonNull Message msg) {
            startAutoImageChange();
        }

        void sleep(){
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), 2000);
        }
    }

    @Override
    public void onPause() {
        imageChangeHandler.removeCallbacksAndMessages(null);
        super.onPause();
    }

    private void setUiPageViewController() {
        imagesLength = addDataList.size();
        imageDotsArray = new ImageView[imagesLength];
        for (int i = 0; i < imagesLength; i++) {
            imageDotsArray[i] = new ImageView(this);
            imageDotsArray[i].setImageDrawable(getResources()
                    .getDrawable(R.drawable.ad_item_not_selected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 0, 10, 0);
            binding.layoutDots.addView(imageDotsArray[i], params);
        }
        imageDotsArray[0].setImageDrawable(getResources()
                .getDrawable(R.drawable.ad_item_selected));
    }
}