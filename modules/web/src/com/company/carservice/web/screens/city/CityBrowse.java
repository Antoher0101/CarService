package com.company.carservice.web.screens.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.City;

@UiController("carservice_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
}