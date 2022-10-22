package com.company.carservice.web.screens.legal;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Legal;

@UiController("carservice_Legal.edit")
@UiDescriptor("legal-edit.xml")
@EditedEntityContainer("legalDc")
@LoadDataBeforeShow
public class LegalEdit extends StandardEditor<Legal> {
}