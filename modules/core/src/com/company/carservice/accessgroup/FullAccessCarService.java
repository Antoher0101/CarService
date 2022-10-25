package com.company.carservice.accessgroup;

import com.company.carservice.entity.CarService;
import com.haulmont.cuba.security.app.group.AnnotatedAccessGroupDefinition;
import com.haulmont.cuba.security.app.group.annotation.AccessGroup;
import com.haulmont.cuba.security.app.group.annotation.JpqlConstraint;
import com.haulmont.cuba.security.group.ConstraintsContainer;

@AccessGroup(name = "Car service Full Access")
public class FullAccessCarService extends AnnotatedAccessGroupDefinition {

    @JpqlConstraint(target = CarService.class)
    @Override
    public ConstraintsContainer accessConstraints() {
        return super.accessConstraints();
    }
}
