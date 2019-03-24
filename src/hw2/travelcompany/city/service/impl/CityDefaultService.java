package hw2.travelcompany.city.service.impl;

import hw2.travelcompany.city.domain.City;
import hw2.travelcompany.city.exception.CityExceptionMeta;
import hw2.travelcompany.city.exception.unchecked.DeleteCityException;
import hw2.travelcompany.city.repo.CityRepo;
import hw2.travelcompany.city.search.CitySearchCondition;
import hw2.travelcompany.city.service.CityService;
import hw2.travelcompany.order.repo.OrderRepo;

import java.util.List;

public class CityDefaultService implements CityService {

    private final CityRepo cityRepo;
    private final OrderRepo orderRepo;

    public CityDefaultService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void insert(City city) {
        if (city != null) {
            cityRepo.insert(city);
        }
    }

    @Override
    public City findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(City city) {
        if (city.getId() != null) {
            this.deleteById(city.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            boolean noOrders = orderRepo.countByCity(id) == 0;
            if (noOrders) {
                cityRepo.deleteById(id);
            } else {
                throw new DeleteCityException(CityExceptionMeta.DELETE_CITY_CONSTRAINT_ERROR);
            }
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public List<? extends City> search(CitySearchCondition searchCondition) {
        return cityRepo.search(searchCondition);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null)
            cityRepo.update(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepo.findAll();
    }
}
