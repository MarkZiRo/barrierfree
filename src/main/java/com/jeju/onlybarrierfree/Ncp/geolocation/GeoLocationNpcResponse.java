package com.jeju.onlybarrierfree.Ncp.geolocation;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoLocationNpcResponse {

    private String requestId;
    private Integer returnCode;
    private GeoLocation geoLocation;
}
