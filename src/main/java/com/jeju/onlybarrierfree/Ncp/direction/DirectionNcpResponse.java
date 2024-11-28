package com.jeju.onlybarrierfree.Ncp.direction;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DirectionNcpResponse {

    private Integer code;
    private String message;
    private String currentDateTime;
    private Map<String, List<DirectionRoute>> route;
}
