package com.company.carservice.service;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

@Service(CarServiceService.NAME)
public class CarServiceServiceBean implements CarServiceService {
    @Inject
    private DataManager dataManager;

    @Override
    public Collection<Employee> getServiceEmployees(CarService carService) {

        return dataManager.load(Employee.class)
                .query("select e from carservice_Employee e where " +
                        "e.carService = :carService")
                .parameter("carService", carService)
                .list();
    }
}