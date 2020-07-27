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
public class EventData {

    @SerializedName("event_id")
    @Expose
    @Getter @Setter
    private long eventId;
    @SerializedName("friendly_start_date")
    @Expose
    @Getter @Setter
    private String friendlyStartDate;
    @SerializedName("friendly_end_date")
    @Expose
    @Getter @Setter
    private String friendlyEndDate;
    @SerializedName("friendly_timing_str")
    @Expose
    @Getter @Setter
    private String friendlyTimingStr;
    @SerializedName("start_date")
    @Expose
    @Getter @Setter
    private String startDate;
    @SerializedName("end_date")
    @Expose
    @Getter @Setter
    private String endDate;
    @SerializedName("end_time")
    @Expose
    @Getter @Setter
    private String endTime;
    @SerializedName("start_time")
    @Expose
    @Getter @Setter
    private String startTime;
    @SerializedName("is_active")
    @Expose
    @Getter @Setter
    private long isActive;
    @SerializedName("date_added")
    @Expose
    @Getter @Setter
    private String dateAdded;
    @SerializedName("photos")
    @Expose
    @Getter @Setter
    private List<Photo> photos = null;
    @SerializedName("restaurants")
    @Expose
    @Getter @Setter
    private List<Object> restaurants = null;
    @SerializedName("is_valid")
    @Expose
    @Getter @Setter
    private long isValid;
    @SerializedName("share_url")
    @Expose
    @Getter @Setter
    private String shareUrl;
    @SerializedName("show_share_url")
    @Expose
    @Getter @Setter
    private long showShareUrl;
    @SerializedName("title")
    @Expose
    @Getter @Setter
    private String title;
    @SerializedName("description")
    @Expose
    @Getter @Setter
    private String description;
    @SerializedName("display_time")
    @Expose
    @Getter @Setter
    private String displayTime;
    @SerializedName("display_date")
    @Expose
    @Getter @Setter
    private String displayDate;
    @SerializedName("is_end_time_set")
    @Expose
    @Getter @Setter
    private long isEndTimeSet;
    @SerializedName("disclaimer")
    @Expose
    @Getter @Setter
    private String disclaimer;
    @SerializedName("event_category")
    @Expose
    @Getter @Setter
    private long eventCategory;
    @SerializedName("event_category_name")
    @Expose
    @Getter @Setter
    private String eventCategoryName;
    @SerializedName("book_link")
    @Expose
    @Getter @Setter
    private String bookLink;
    @SerializedName("types")
    @Expose
    @Getter @Setter
    private List<TypeList> types = null;
    @SerializedName("share_data")
    @Expose
    @Getter @Setter
    private ShareData shareData;
}
