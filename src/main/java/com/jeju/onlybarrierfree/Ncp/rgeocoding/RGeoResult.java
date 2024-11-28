package com.jeju.onlybarrierfree.Ncp.rgeocoding;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RGeoResult {
    private String name;
    private Map<String, String> code;
    private RGeoRegion region;
}
