package com.example.springinit.formatter;

import com.example.springinit.model.City;
import com.example.springinit.service.impl.CityServiceImpl;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CityFormatter implements Formatter<City> {

    private final CityServiceImpl cityService;

    public CityFormatter(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    public City parse(String text, Locale locale) {
        return cityService.findById(Long.parseLong(text));
    }

    @Override
    public String print(City object, Locale locale) {
        return null;
    }
}
