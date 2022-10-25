package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@PublishEntityChangedEvents
@Table(name = "CARSERVICE_CITY", indexes = {
        @Index(name = "IDX_CARSERVICE_CITY_NAME", columnList = "NAME", unique = true)
})
@Entity(name = "carservice_City")
@NamePattern("%s|name")
public class City extends StandardEntity {
    private static final long serialVersionUID = 4424352755530112832L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "PHONE_CODE", nullable = false)
    private String phoneCode;

    @Column(name = "DEFAULT_CITY", nullable = false)
    @NotNull
    private Boolean defaultCity = false;

    public Boolean getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(Boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}