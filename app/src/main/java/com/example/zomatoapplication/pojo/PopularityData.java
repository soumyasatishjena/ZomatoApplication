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
public class PopularityData {

    @SerializedName("popularity")
    @Expose
    @Getter @Setter
    private String popularity;
    @SerializedName("nightlife_index")
    @Expose
    @Getter @Setter
    private String nightlifeIndex;
    @SerializedName("nearby_res")
    @Expose
    @Getter @Setter
    private List<String> nearbyRes = null;
    @SerializedName("top_cuisines")
    @Expose
    @Getter @Setter
    private List<String> topCuisines = null;
    @SerializedName("popularity_res")
    @Expose
    @Getter @Setter
    private String popularityRes;
    @SerializedName("nightlife_res")
    @Expose
    @Getter @Setter
    private String nightlifeRes;
    @SerializedName("subzone")
    @Expose
    @Getter @Setter
    private String subzone;
    @SerializedName("subzone_id")
    @Expose
    @Getter @Setter
    private long subzoneId;
    @SerializedName("city")
    @Expose
    @Getter @Setter
    private String city;
}
