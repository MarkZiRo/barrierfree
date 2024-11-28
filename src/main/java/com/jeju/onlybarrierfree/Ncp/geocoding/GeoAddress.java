package com.jeju.onlybarrierfree.Ncp.geocoding;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeoAddress {

    private String roadAddress;
    private String jibunAddress;
    private String englishAddress;
    private List<Object> addressElements;
    private String x;
    private String y;
    private Double distance;

}
