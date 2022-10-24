package com.company.carservice.jmx;

import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.sys.persistence.DbTypeConverter;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Component("carservice_EmployeeWorker")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    protected Persistence persistence;
    @Inject
    private TimeSource timeSource;
    @Inject
    private Scripting scripting;

    @Override
    public void sendGreetings() {
        try (Transaction tx = persistence.createTransaction()) {
            Date nowDate = timeSource.currentTimestamp();
            Query query = persistence.getEntityManager().createNativeQuery(
                    "select " +
                            "first_name, " +
                            "last_name, " +
                            "(extract(year from (age(#nowDate::date, birthday))))::integer as age, " +
                            "email, " +
                            "carservice_car_service.name as car_service_name " +
                            "from carservice_employee " +
                            "join carservice_car_service on carservice_car_service.id = car_service_id " +
                            "where extract(month from birthday) = extract(month from #nowDate::date) " +
                            "and extract(day from birthday) = extract(day from #nowDate::date)");
            query.setParameter("nowDate", nowDate);
            List list = query.getResultList();

            for (Object o : list) {
                Object[] row = (Object[]) o;
                String name = (String) row[0];
                String lastName = (String) row[1];
                int age = (int) row[2];
                String email = (String) row[3];
                String carServiceName = (String) row[4];

                if (email == null) continue;

                // Groovy
                Binding binding = new Binding();
                binding.setVariable("name", name);
                binding.setVariable("lastName", lastName);
                binding.setVariable("age", age);
                binding.setVariable("carServiceName", carServiceName);
                String greetingMessage = scripting.runGroovyScript("com/company/carservice/GetGreetingMessage.groovy", binding);
            }
        }
    }
}