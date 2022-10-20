package com.company.carservice.web.screens.city;

import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("carservice_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
    @Inject
    private CityService cityService;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        City editedCity = getEditedEntity();
        cityService.resetDefaultCity(editedCity);
    }
}