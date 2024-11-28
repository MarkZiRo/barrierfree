package com.jeju.onlybarrierfree.Ncp.geocoding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GeoNcpResponse {
    private String status;
    private GeoMeta meta;
    private List<GeoAddress> addresses;
    private String errorMessage;
}
