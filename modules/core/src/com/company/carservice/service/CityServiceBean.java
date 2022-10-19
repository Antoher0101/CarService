package com.company.carservice.service;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.inject.Inject;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {
    @Inject
    private DataManager dm;

    @Nullable
    @Override
    public City getDefaultCity() {
        Long isDefaultCityExist = dm.loadValue("select count(d) from carservice_City d where d.defaultCity = 't'", Long.class).one();

        if (isDefaultCityExist > 0){
            return dm.loadValue("select city from carservice_City city where city.defaultCity = 't'", City.class)
                    .one();
        }
        return null;
    }
}