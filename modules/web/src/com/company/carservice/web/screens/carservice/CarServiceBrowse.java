package com.company.carservice.web.screens.carservice;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.CarService;

@UiController("carservice_CarService.browse")
@UiDescriptor("car-service-browse.xml")
@LookupComponent("carServicesTable")
@LoadDataBeforeShow
public class CarServiceBrowse extends StandardLookup<CarService> {
}