package com.jeju.onlybarrierfree.Ncp.rgeocoding;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RGeoNcpResponse {
    private Map<String, String> status;
    private List<RGeoResult> results;
}
