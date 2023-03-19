package com.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class Picture implements Serializable {
    private static final long serialVersionUID = 1L;
    public String large;
    public String medium;
    public String thumbnail;

    @Override
    public String toString() {
        return "Picture{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public Picture(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public Picture() {
    }
}
