package com.example.zomatoapplication.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ViewPagerData {

    @Getter @Setter
    private String image;
    @Getter @ Setter
    private String title;

    public ViewPagerData(String image, String title) {
        this.image = image;
        this.title = title;
    }
}
