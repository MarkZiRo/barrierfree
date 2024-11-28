package com.jeju.onlybarrierfree.Ncp.direction;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DirectionRoute {

    private Map<String, Object> summary;
    private List<List<Double>> path;
    private List<Object> section;
    private List<Object> guide;

}
