package com.company.carservice.web.screens.city;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.actions.list.EditAction;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("carservice_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
    @Inject
    private CollectionLoader<City> citiesDl;
    @Install(to = "citiesTable.edit", subject = "afterCommitHandler")
    protected void customersTableCreateAfterCommitHandler(City entity) {
        citiesDl.load();
    }
}