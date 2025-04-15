package com.example.mcp.services;

import com.example.mcp.PointsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service

public class WeatherService {
    public static final String WEATHER_API_URL = "https://api.weather.gov";
    private final RestTemplate restTemplate;

    public WeatherService() {
        this.restTemplate = new RestTemplate();
    }

    @Tool(description = "Get weather forecast for a specific latitude/longitude")
    public String getWeatherForecastByLocation(
            double latitude,   // Latitude coordinate
            double longitude   // Longitude coordinate
    ) {
        PointsDto pointsDto =  restTemplate.getForObject(WEATHER_API_URL+"/points/%s,%s".formatted(latitude,longitude), PointsDto.class);
        String forecastUrl = pointsDto.getProperties().getForecastUrl();
        return restTemplate.getForObject(forecastUrl, String.class);

    }

//    @Tool(description = "Get weather alerts for a US state")
//    public String getAlerts(
//            @ToolParam(description = "Two-letter US state code (e.g. CA, NY)" String state
//            ) {
//        // Returns active alerts including:
//        // - Event type
//        // - Affected area
//        // - Severity
//        // - Description
//        // - Safety instructions
//    }
}
