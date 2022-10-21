package com.company.carservice.web.screens.city;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.City;

import javax.inject.Inject;

@UiController("carservice_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
    @Inject
    private CollectionLoader<City> citiesDl;

    @Install(to = "citiesTable.edit", subject = "afterCommitHandler")
    protected void customAfterCommitHandler(City city){
        citiesDl.load();
    }
}