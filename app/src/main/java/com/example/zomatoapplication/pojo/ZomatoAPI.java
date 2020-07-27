package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ZomatoAPI {

    @SerializedName("location")
    @Expose
    @Getter @Setter
    private LocationData location;
    @SerializedName("popularity")
    @Expose
    @Getter @Setter
    private PopularityData popularity;
    @SerializedName("link")
    @Expose
    @Getter @Setter
    private String link;
    @SerializedName("nearby_restaurants")
    @Expose
    @Getter @Setter
    private List<NearbyRestaurant> nearbyRestaurants = null;
}
