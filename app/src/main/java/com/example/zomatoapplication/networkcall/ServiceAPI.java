package com.example.zomatoapplication.networkcall;


import com.example.zomatoapplication.pojo.ZomatoAPI;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ServiceAPI {

    @GET("geocode")
    Single<ZomatoAPI> getZomatoAPI(@Header("user-key") String apiKey,
                                   @Query("lat") double lat, @Query("lon") double lon);

}
