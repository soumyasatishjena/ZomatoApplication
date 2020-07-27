package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class NearbyRestaurant {

    @SerializedName("restaurant")
    @Expose
    @Getter @Setter
    private Restaurant restaurant;
}
