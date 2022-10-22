package com.company.carservice.web.screens.carservice;

import com.company.carservice.entity.*;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.GlobalConfig;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@UiController("carservice_CarService.edit")
@UiDescriptor("car-service-edit.xml")
@EditedEntityContainer("carServiceDc")
@LoadDataBeforeShow
public class CarServiceEdit extends StandardEditor<CarService> {
    @Inject
    private CityService cityService;
    @Inject
    private TabSheet carServiceEditTabSheet;
    @Inject
    private GroupTable<Counterparty> counterpartiesTable;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private Messages messages;
    @Inject
    private CollectionPropertyContainer<Counterparty> counterpartiesDc;

    @Subscribe
    public void onInit(InitEvent event) {
        counterpartiesTable.addGeneratedColumn("clientType", new Table.ColumnGenerator<Counterparty>() {
            @Nullable
            @Override
            public Component generateCell(Counterparty entity) {
                Label<String> label = uiComponents.create(Label.TYPE_STRING);
                String value = "-";
                if(entity.getClass() == Legal.class) value = messages.getMessage(getClass(), "clientType.legal");
                if(entity.getClass() == Individual.class) value = messages.getMessage(getClass(), "clientType.individual");
                label.setValue(value);
                return label;
            }
        });
        counterpartiesTable.getColumn("clientType")
                .setCaption(messages.getMessage(getClass(), "clientType.caption"));
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarService> event) {
        City defaultCity = cityService.getDefaultCity();

        if (defaultCity != null)
            event.getEntity().setCity(defaultCity);
    }

    @Subscribe(id = "counterpartiesDc", target = Target.DATA_CONTAINER)
    public void onCounterpartiesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Counterparty> event) {
        String newCaption = messages.getMessage(getClass(), "clientsTab.caption") + " (" + event.getSource().getItems().size() + ")";
        carServiceEditTabSheet.getTab("clientsTab").setCaption(newCaption);
    }


}