package com.company.carservice.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Individual;

@UiController("carservice_Individual.edit")
@UiDescriptor("individual-edit.xml")
@EditedEntityContainer("individualDc")
@LoadDataBeforeShow
public class IndividualEdit extends StandardEditor<Individual> {
}