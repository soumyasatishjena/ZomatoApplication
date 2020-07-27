package com.example.zomatoapplication.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.zomatoapplication.networkcall.NetworkClient;
import com.example.zomatoapplication.networkcall.ServiceAPI;
import com.example.zomatoapplication.pojo.ZomatoAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.zomatoapplication.utility.Utility.API_KEY;

public class HomeRepository {

    private ServiceAPI serviceAPI;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomeRepository(){
        serviceAPI = NetworkClient.getServiceApi();
    }


    public LiveData<ZomatoAPI> getZomotoData(double lat, double lon) {

        MutableLiveData<ZomatoAPI> getLiveData = new MutableLiveData<>();
        Disposable disposable = serviceAPI.getZomatoAPI(API_KEY, lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ZomatoAPI>() {
                    @Override
                    public void onSuccess(ZomatoAPI zomatoAPI) {
                        getLiveData.postValue(zomatoAPI);
                    }
                    @Override
                    public void onError(Throwable e) {
                        getLiveData.postValue(null);
                    }
                });
        compositeDisposable.add(disposable);
        return getLiveData;
    }

    public void onReset(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
            compositeDisposable.dispose();
        }
    }
}
