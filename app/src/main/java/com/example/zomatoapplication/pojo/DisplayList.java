package com.example.zomatoapplication.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class DisplayList {

    @Getter @Setter
    private String restaurantName;
    @Getter @Setter
    private String restaurantAddress;
    @Getter @Setter
    private String restaurantLocality;
    @Getter @Setter
    private String restaurantCuisine;
    @Getter @Setter
    private String restaurantAverageCost;
    @Getter @Setter
    private String restaurantThumb;
    @Getter @Setter
    private String restaurantAverageRating;
    @Getter @Setter
    private String restaurantRatingText;
    @Getter @Setter
    private String votes;
    @Getter @Setter
    private String restaurantRatingColour;
    @Getter @Setter
    private int hasOnlineDelivery;
    @Getter @Setter
    private int isDeliveringNow;

    public DisplayList(String restaurantName, String restaurantAddress, String restaurantLocality,
                       String restaurantCuisine, String restaurantAverageCost,
                       String restaurantThumb, String restaurantAverageRating,
                       String restaurantRatingText, String votes, String restaurantRatingColour,
                       int hasOnlineDelivery, int isDeliveringNow) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantLocality = restaurantLocality;
        this.restaurantCuisine = restaurantCuisine;
        this.restaurantAverageCost = restaurantAverageCost;
        this.restaurantThumb = restaurantThumb;
        this.restaurantAverageRating = restaurantAverageRating;
        this.restaurantRatingText = restaurantRatingText;
        this.votes = votes;
        this.restaurantRatingColour = restaurantRatingColour;
        this.hasOnlineDelivery = hasOnlineDelivery;
        this.isDeliveringNow = isDeliveringNow;
    }

}
