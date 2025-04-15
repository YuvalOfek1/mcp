package com.example.mcp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertiesDto {
    @JsonProperty(value = "forecast")
    String forecastUrl;

    public String getForecastUrl() {
        return forecastUrl;
    }
}
