package com.company.carservice.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "CARSERVICE_CAR_SERVICE")
@Entity(name = "carservice_CarService")
@NamePattern("%s|name")
public class CarService extends StandardEntity {
    private static final long serialVersionUID = -8733963328113168384L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID")
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @OnDeleteInverse(DeletePolicy.DENY)
    private City city;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "carService")
    @Composition
    private List<Employee> employee;

    @Composition
    @OneToMany(mappedBy = "carService")
    private List<Repair> repair;

    @JoinTable(name = "CARSERVICE_COUNTERPARTY_CAR_SERVICE_LINK",
            joinColumns = @JoinColumn(name = "CAR_SERVICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "COUNTERPARTY_ID"))
    @ManyToMany
    private List<Counterparty> counterparties;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Counterparty> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<Counterparty> counterparties) {
        this.counterparties = counterparties;
    }

    public List<Repair> getRepair() {
        return repair;
    }

    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}