package com.company.carservice.web.screens.carservice;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.City;
import com.company.carservice.entity.Counterparty;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.actions.picker.LookupAction;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.VBoxLayout;
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
    @Named("carServiceEditTabSheet.clientsTab")
    private VBoxLayout clientsTab;
    @Inject
    private MessageBundle messageBundle;
    @Inject
    private TabSheet carServiceEditTabSheet;

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarService> event) {
        City defaultCity = cityService.getDefaultCity();

        if (defaultCity != null)
            event.getEntity().setCity(defaultCity);
    }

    @Subscribe(id = "counterpartiesDc", target = Target.DATA_CONTAINER)
    public void onCounterpartiesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Counterparty> event) {
        String newCaption = messageBundle.getMessage("clientsTab.caption") +
                " (" + event.getSource().getItems().size() + ")";
        carServiceEditTabSheet.getTab("clientsTab").setCaption(newCaption);
    }
}