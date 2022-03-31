package de.vw.f73.springboot.exampleProject.cars;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRepository {

  public List<Car> getAllCars() {
    return CarStorage.getInstance().getAllCars();
  }

  public void addCar(Car car) {
    CarStorage.getInstance().writeCar(car);
  }

  public List<Car> findCarByID(String id) {
    return CarStorage.getInstance().findCarById(id);
  }

  public void deleteCarByID(String id) {
    CarStorage.getInstance().deleteCarByID(id);
  }

  public void updateCarByID(String id, Car car) {
    CarStorage.getInstance().updateCarByID(id, car);
  }
}
