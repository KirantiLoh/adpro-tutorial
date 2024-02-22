package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car findById(String id);

    List<Car> findAll();

    void update(String id, Car car);

    void delete(String id);
}
