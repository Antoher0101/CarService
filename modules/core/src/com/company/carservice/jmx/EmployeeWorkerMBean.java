package com.company.carservice.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

@JmxBean(module = "carservice", alias = "EmployeeWorker")
@ManagedResource(description = "JMX bean for employee")
public interface EmployeeWorkerMBean {
    @ManagedOperation(description = "Send birthdays greetings email to employees")
    void sendGreetings();
}