package de.vw.f73.springboot.exampleProject.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarResources {

  @Autowired private CarService carService;

  @GetMapping("getall")
  public ResponseEntity<List<Car>> getAllCars() {
    List<Car> carList = this.carService.getAllCars();
    return new ResponseEntity<>(carList, HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<Car> addCar(@RequestBody Car car) {
    this.carService.addCar(car);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("get/{id}")
  public ResponseEntity<List<Car>> getCarById(@PathVariable("id") String id) {
    List<Car> car = this.carService.findCarByID(id);
    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<Car> deleteCarById(@PathVariable("id") String id) {
    this.carService.deleteCarByID(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("update/{id}")
  public ResponseEntity<Car> updateCarById(@PathVariable("id") String id, @RequestBody Car car) {
    this.carService.updateCarByID(id, car);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
