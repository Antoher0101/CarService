package com.company.carservice.web.screens.counterparty;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Counterparty;

@UiController("carservice_Counterparty.browse")
@UiDescriptor("counterparty-browse.xml")
@LookupComponent("counterpartiesTable")
@LoadDataBeforeShow
public class CounterpartyBrowse extends StandardLookup<Counterparty> {
}