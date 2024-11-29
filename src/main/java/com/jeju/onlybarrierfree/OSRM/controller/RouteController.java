package com.jeju.onlybarrierfree.OSRM.controller;

import com.jeju.onlybarrierfree.OSRM.Service.OpenRouteService;
import com.jeju.onlybarrierfree.OSRM.dto.Coordinate;
import com.jeju.onlybarrierfree.OSRM.dto.ORSRouteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final OpenRouteService routeService;

    // '/api/routes/accessible' 엔드포인트로 GET 요청을 받아서 경로를 계산
    @GetMapping("/accessible")
    public Object getAccessibleRoute(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        // start와 end 좌표를 "경도,위도" 형식으로 받아 파싱
        return routeService.getAccessibleRoute(start, end);
    }
}
