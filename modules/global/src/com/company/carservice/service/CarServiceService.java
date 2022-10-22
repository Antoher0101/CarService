package com.company.carservice.service;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.Employee;

import java.util.Collection;

public interface CarServiceService {
    String NAME = "carservice_CarService";

    Collection<Employee> getServiceEmployees(CarService carService);
}