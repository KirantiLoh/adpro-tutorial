package id.ac.ui.cs.advprog.eshop.repository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.UUID;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Repository
public class CarRepository {
    static int id = 0;

    private List<Car> cars = new ArrayList<>();

    public Car create(Car car) {
        if (car.getId() == null) {
            car.setId(UUID.randomUUID().toString());
        }
        cars.add(car);
        return car;
    }

    public Car findById(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public Iterator<Car> findAll() {
        return cars.iterator();
    }

    public Car update(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(car.getId())) {
                cars.set(i, car);
                return car;
            }
        }
        return null;
    }

    public void delete(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}
