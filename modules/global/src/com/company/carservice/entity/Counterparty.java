package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "CARSERVICE_COUNTERPARTY")
@Entity(name = "carservice_Counterparty")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s|name")
public class Counterparty extends StandardEntity {
    private static final long serialVersionUID = -3000144533101363784L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinTable(name = "CARSERVICE_COUNTERPARTY_CAR_SERVICE_LINK",
            joinColumns = @JoinColumn(name = "COUNTERPARTY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    private List<CarService> carService;

    public List<CarService> getCarService() {
        return carService;
    }

    public void setCarService(List<CarService> carService) {
        this.carService = carService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}