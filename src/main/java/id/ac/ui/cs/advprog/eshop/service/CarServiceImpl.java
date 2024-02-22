package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import java.util.List;
import java.util.ArrayList;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.create(car);
    }

    @Override
    public Car findById(String id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEachRemaining(cars::add);
        return cars;
    }

    @Override
    public void update(String id, Car car) {
        carRepository.update(car);
    }

    @Override
    public void delete(String id) {
        carRepository.delete(id);
    }

}
