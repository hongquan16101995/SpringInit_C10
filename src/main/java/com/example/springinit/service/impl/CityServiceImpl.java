package com.example.springinit.service.impl;

import com.example.springinit.model.City;
import com.example.springinit.model.Employee;
import com.example.springinit.service.ICrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl {

    private final List<City> cities;

    public CityServiceImpl() {
        cities = new ArrayList<>();
        cities.add(new City(1L, "HN"));
        cities.add(new City(2L, "HP"));
    }

    public List<City> findAll() {
        return cities;
    }

    public City findById(Long id) {
        for (City c : cities) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
