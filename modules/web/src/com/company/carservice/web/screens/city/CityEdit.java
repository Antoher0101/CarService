package com.company.carservice.web.screens.city;

import com.company.carservice.entity.City;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;

@UiController("carservice_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
    @Inject
    private CityService cityService;
    @Inject
    private DataManager dataManager;
    @Inject
    private InstanceContainer<City> cityDc;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        
    }
}