package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class LocationData {


    @SerializedName("entity_type")
    @Expose
    @Getter @Setter
    private String entityType;
    @SerializedName("entity_id")
    @Expose
    @Getter @Setter
    private long entityId;
    @SerializedName("title")
    @Expose
    @Getter @Setter
    private String title;
    @SerializedName("latitude")
    @Expose
    @Getter @Setter
    private String latitude;
    @SerializedName("longitude")
    @Expose
    @Getter @Setter
    private String longitude;
    @SerializedName("city_id")
    @Expose
    @Getter @Setter
    private long cityId;
    @SerializedName("city_name")
    @Expose
    @Getter @Setter
    private String cityName;
    @SerializedName("country_id")
    @Expose
    @Getter @Setter
    private long countryId;
    @SerializedName("country_name")
    @Expose
    @Getter @Setter
    private String countryName;
}
