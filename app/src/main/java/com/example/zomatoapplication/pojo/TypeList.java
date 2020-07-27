package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class TypeList {

    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("color")
    @Expose
    @Getter @Setter
    private String color;
}
