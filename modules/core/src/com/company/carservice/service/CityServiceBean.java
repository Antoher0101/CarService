package com.company.carservice.service;

import com.company.carservice.entity.CarService;
import com.company.carservice.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {
    @Inject
    private DataManager dm;
    @Inject
    private Persistence persistence;

    @Nullable
    @Override
    public City getDefaultCity() {
        Long isDefaultCityExist = dm.loadValue("select count(d) from carservice_City d where d.defaultCity = 't'", Long.class).one();

        if (isDefaultCityExist > 0){
            return dm.loadValue("select city from carservice_City city where city.defaultCity = 't'", City.class)
                    .one();
        }
        return null;
    }

    @Override
    public void resetDefaultCity(City changedCity) {
        try (Transaction tx = persistence.createTransaction()) {

            EntityManager em = persistence.getEntityManager();

            Query query = em.createQuery(
                    "select c from carservice_City c where c.defaultCity = 't' and c <> :changedCity")
                    .setParameter("changedCity", changedCity);
            List<City> resultList = (List<City>) query.getResultList();
            for (City city : resultList) {
                city.setDefaultCity(false);
            }
            tx.commit();
        }
    }
}