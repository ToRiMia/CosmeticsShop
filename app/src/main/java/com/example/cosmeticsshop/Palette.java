package com.example.cosmeticsshop;

import androidx.annotation.NonNull;

public class Palette {
    private String title;
    private String info;
    private int imageResourceId;

    public Palette(String title, String info, int imageResourceId) {
        this.title = title;
        this.info = info;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
