package de.vw.f73.springboot.exampleProject.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

  @Autowired private CarRepository carRepository;

  public List<Car> getAllCars() {
    return this.carRepository.getAllCars();
  }

  public void addCar(Car car) {
    this.carRepository.addCar(car);
  }

  public List<Car> findCarByID(String id) {
    return this.carRepository.findCarByID(id);
  }

  public void deleteCarByID(String id) {
    this.carRepository.deleteCarByID(id);
  }

  public void updateCarByID(String id, Car car) {
    this.carRepository.updateCarByID(id, car);
  }
}
