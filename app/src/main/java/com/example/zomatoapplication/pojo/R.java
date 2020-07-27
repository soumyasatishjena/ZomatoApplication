package com.example.zomatoapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class R {

    @SerializedName("has_menu_status")
    @Expose
    @Getter @Setter
    private HasMenuStatus hasMenuStatus;
    @SerializedName("res_id")
    @Expose
    @Getter @Setter
    private long resId;
    @SerializedName("is_grocery_store")
    @Expose
    @Getter @Setter
    private boolean isGroceryStore;
}
