package de.vw.f73.springboot.exampleProject.cars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class CarStorage {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final String FILE_PATH = "src/main/resources/cars.json";
  private static List<Car> carList = new ArrayList<>();
  private static CarStorage instance = null;

  public static CarStorage getInstance() {
    if (instance == null) {
      instance = new CarStorage();
    }
    return instance;
  }

  private void readStorage() {
    try (InputStream inputStream = new FileInputStream(FILE_PATH)) {
      carList = OBJECT_MAPPER.readValue(inputStream, new TypeReference<ArrayList<Car>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeStorage() {
    try {
      OBJECT_MAPPER.writeValue(new File(FILE_PATH), carList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Car> getAllCars() {
    readStorage();
    return carList;
  }

  public void writeCar(Car car) {
    readStorage();
    car.setUuid(UUID.randomUUID());
    carList.add(car);
    writeStorage();
  }

  public List<Car> findCarById(String id) {
    readStorage();
    return carList.stream()
        .filter(car -> car.getUuid().toString().equals(id))
        .collect(Collectors.toList());
  }

  public void deleteCarByID(String id) {
    readStorage();
    carList =
        carList.stream()
            .filter(car -> !car.getUuid().toString().equals(id))
            .collect(Collectors.toList());
    writeStorage();
  }

  public void updateCarByID(String id, Car car) {
    readStorage();
    carList =
        carList.stream()
            .filter(c -> c.getUuid().toString().equals(id))
            .collect(Collectors.toList());
    carList.add(car);
    writeStorage();
  }
}
