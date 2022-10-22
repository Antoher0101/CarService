package com.company.carservice.web.screens.individual;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Individual;

@UiController("carservice_Individual.browse")
@UiDescriptor("individual-browse.xml")
@LookupComponent("individualsTable")
@LoadDataBeforeShow
public class IndividualBrowse extends StandardLookup<Individual> {
}