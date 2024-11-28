package com.jeju.onlybarrierfree.Ncp.dto;

import lombok.Getter;

@Getter
public class PointDto {
    private Double lat;
    private Double lng;

    public String toQueryValue() {
        return String.format("%f,%f", lng, lat);
    }
}
