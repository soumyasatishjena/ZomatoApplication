package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class HasMenuStatus {

    @SerializedName("delivery")
    @Expose
    @Getter @Setter
    private long delivery;
    @SerializedName("takeaway")
    @Expose
    @Getter @Setter
    private long takeaway;
}
