package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class RatingObj {

    @SerializedName("title")
    @Expose
    @Getter @Setter
    private TitleData title;
    @SerializedName("bg_color")
    @Expose
    @Getter @Setter
    private BgColor bgColor;
}
