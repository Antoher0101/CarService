package com.company.carservice.web.screens.carservice;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.CarService;

@UiController("carservice_CarService.edit")
@UiDescriptor("car-service-edit.xml")
@EditedEntityContainer("carServiceDc")
@LoadDataBeforeShow
public class CarServiceEdit extends StandardEditor<CarService> {
}