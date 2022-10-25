package com.company.carservice.role;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.entity.annotation.LocalizedValue;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = "Common user", description = "Common user can browse cities without editing")
public class CommonUserRole extends AnnotatedRoleDefinition {

    @EntityAccess(entityClass = City.class, operations = {EntityOp.READ})
    @Override
    public EntityPermissionsContainer entityPermissions(){
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = City.class, view = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions(){
        return super.entityAttributePermissions();
    }

    @ScreenAccess(screenIds = {"application-carservice","carservice_City.browse"})
    @Override
    public ScreenPermissionsContainer screenPermissions(){
        return super.screenPermissions();
    }
}
