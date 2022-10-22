package com.company.carservice.web.screens.legal;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Legal;

@UiController("carservice_Legal.browse")
@UiDescriptor("legal-browse.xml")
@LookupComponent("legalsTable")
@LoadDataBeforeShow
public class LegalBrowse extends StandardLookup<Legal> {
}