package com.company.carservice.web.screens.carservice;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.actions.picker.LookupAction;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("carservice_CarService.edit")
@UiDescriptor("car-service-edit.xml")
@EditedEntityContainer("carServiceDc")
@LoadDataBeforeShow
public class CarServiceEdit extends StandardEditor<CarService> {
    private static final Logger log = LoggerFactory.getLogger(CarServiceEdit.class);
    @Inject
    private CityService cityService;
    @Inject
    private LookupPickerField<City> cityField;
    @Inject
    private CollectionContainer<City> citiesDc;

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarService> event) {
        City defaultCity = cityService.getDefaultCity();

        if (defaultCity != null)
            event.getEntity().setCity(defaultCity);
    }
}