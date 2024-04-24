package com.aya.client;

import com.aya.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherApiClient {


    //    http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=London

    @GetMapping("/current")
    WeatherDTO getCurrentWeather(@RequestParam(value = "access_key")String accessKey,
                                 @RequestParam(value = "query")String city);





}
