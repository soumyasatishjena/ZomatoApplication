package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class UserRating {

    @SerializedName("aggregate_rating")
    @Expose
    @Getter @Setter
    private String aggregateRating;
    @SerializedName("rating_text")
    @Expose
    @Getter @Setter
    private String ratingText;
    @SerializedName("rating_color")
    @Expose
    @Getter @Setter
    private String ratingColor;
    @SerializedName("rating_obj")
    @Expose
    @Getter @Setter
    private RatingObj ratingObj;
    @SerializedName("votes")
    @Expose
    @Getter @Setter
    private long votes;
}
