package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PhotoData {

    @SerializedName("url")
    @Expose
    @Getter @Setter
    private String url;
    @SerializedName("thumb_url")
    @Expose
    @Getter @Setter
    private String thumbUrl;
    @SerializedName("order")
    @Expose
    @Getter @Setter
    private long order;
    @SerializedName("md5sum")
    @Expose
    @Getter @Setter
    private String md5sum;
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private long id;
    @SerializedName("photo_id")
    @Expose
    @Getter @Setter
    private long photoId;
    @SerializedName("uuid")
    @Expose
    @Getter @Setter
    private long uuid;
    @SerializedName("type")
    @Expose
    @Getter @Setter
    private String type;
}
