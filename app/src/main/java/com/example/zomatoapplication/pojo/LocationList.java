package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class LocationList {

    @SerializedName("address")
    @Expose
    @Getter @Setter
    private String address;
    @SerializedName("locality")
    @Expose
    @Getter @Setter
    private String locality;
    @SerializedName("city")
    @Expose
    @Getter @Setter
    private String city;
    @SerializedName("city_id")
    @Expose
    @Getter @Setter
    private long cityId;
    @SerializedName("latitude")
    @Expose
    @Getter @Setter
    private String latitude;
    @SerializedName("longitude")
    @Expose
    @Getter @Setter
    private String longitude;
    @SerializedName("zipcode")
    @Expose
    @Getter @Setter
    private String zipcode;
    @SerializedName("country_id")
    @Expose
    @Getter @Setter
    private long countryId;
    @SerializedName("locality_verbose")
    @Expose
    @Getter @Setter
    private String localityVerbose;

}
