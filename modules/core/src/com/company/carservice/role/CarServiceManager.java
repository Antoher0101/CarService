package com.company.carservice.role;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.Counterparty;
import com.company.carservice.entity.Employee;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.*;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = "Car services manager", description = "Сan edit any car service")
public class CarServiceManager extends AnnotatedRoleDefinition {

    @EntityAccess(entityClass = CarService.class, operations = {EntityOp.READ, EntityOp.UPDATE})
    @EntityAccess(entityClass = Employee.class, operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @EntityAccess(entityClass = Counterparty.class, operations = {EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = CarService.class,
            modify = {"address", "counterparties", "phoneNumber", "employee"},
            view = {"city", "creator"})
    @EntityAttributeAccess(entityClass = Employee.class, modify = "*")
    @EntityAttributeAccess(entityClass = Counterparty.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenAccess(screenIds = {
            "application-carservice",
            "carservice_CarService.browse",
            "carservice_CarService.edit",
            "carservice_Counterparty.edit",
            "carservice_Counterparty.browse",
            "carservice_Employee.edit"
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}
