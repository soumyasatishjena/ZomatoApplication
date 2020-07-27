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
public class Restaurant {

    @SerializedName("R")
    @Expose
    @Getter @Setter
    private R r;
    @SerializedName("apikey")
    @Expose
    @Getter @Setter
    private String apikey;
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private String id;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("url")
    @Expose
    @Getter @Setter
    private String url;
    @SerializedName("location")
    @Expose
    @Getter @Setter
    private LocationList location;
    @SerializedName("switch_to_order_menu")
    @Expose
    @Getter @Setter
    private long switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    @Getter @Setter
    private String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    @Getter @Setter
    private long averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    @Getter @Setter
    private long priceRange;
    @SerializedName("currency")
    @Expose
    @Getter @Setter
    private String currency;
    @SerializedName("offers")
    @Expose
    @Getter @Setter
    private List<Object> offers = null;
    @SerializedName("opentable_support")
    @Expose
    @Getter @Setter
    private long opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    @Getter @Setter
    private long isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    @Getter @Setter
    private String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    @Getter @Setter
    private long isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    @Getter @Setter
    private String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    @Getter @Setter
    private String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    @Getter @Setter
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    @Getter @Setter
    private UserRating userRating;
    @SerializedName("photos_url")
    @Expose
    @Getter @Setter
    private String photosUrl;
    @SerializedName("menu_url")
    @Expose
    @Getter @Setter
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    @Getter @Setter
    private String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    @Getter @Setter
    private long hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    @Getter @Setter
    private long isDeliveringNow;
    @SerializedName("store_type")
    @Expose
    @Getter @Setter
    private String storeType;
    @SerializedName("include_bogo_offers")
    @Expose
    @Getter @Setter
    private boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    @Getter @Setter
    private String deeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    @Getter @Setter
    private long isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    @Getter @Setter
    private long hasTableBooking;
    @SerializedName("events_url")
    @Expose
    @Getter @Setter
    private String eventsUrl;
    @SerializedName("medio_provider")
    @Expose
    @Getter @Setter
    private long medioProvider;
    @SerializedName("zomato_events")
    @Expose
    @Getter @Setter
    private List<ZomatoEvent> zomatoEvents = null;
}
