package com.example.zomatoapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.zomatoapplication.pojo.ZomatoAPI;
import com.example.zomatoapplication.repository.HomeRepository;

public class HomeViewModel extends ViewModel {

    private HomeRepository homeRepository;

    public HomeViewModel() {
        this.homeRepository = new HomeRepository();
    }

    public LiveData<ZomatoAPI> getZomatoApi(double lat, double lon){
        return homeRepository.getZomotoData(lat, lon);
    }

    @Override
    protected void onCleared() {
        homeRepository.onReset();
        super.onCleared();
    }

    public void reset() {
        onCleared();
    }

}
