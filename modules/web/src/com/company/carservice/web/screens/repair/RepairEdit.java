package com.company.carservice.web.screens.repair;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.Employee;
import com.company.carservice.service.CarServiceService;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Repair;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@UiController("carservice_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {
    @Inject
    private CollectionContainer<Employee> employeesDc;
    @Inject
    private CarServiceService carServiceService;
    @Inject
    private LookupPickerField<Employee> employeeField;

    @Subscribe("carServiceField")
    public void onCarServiceFieldValueChange(HasValue.ValueChangeEvent<CarService> event) {
        employeeField.setValue(null);
        employeesDc.setItems(carServiceService.getServiceEmployees(event.getValue()));
    }
}